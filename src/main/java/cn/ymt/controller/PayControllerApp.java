package cn.ymt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ymt.pojo.User;
import cn.ymt.serviceDao.OrdersServiceDao;
import cn.ymt.serviceDao.ShopcartServiceDao;
import cn.ymt.util.AlipayConfig;
import cn.ymt.view.OrdersView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;

@CrossOrigin
@Controller
@RequestMapping("/payApp")
public class PayControllerApp {
	@Autowired
	private OrdersServiceDao orderServiceDao ;
	@Autowired
	private ShopcartServiceDao shopcartServiceDao ;


	@RequestMapping(value = "/pay", method = { RequestMethod.GET, RequestMethod.POST })
	public void pay(HttpServletRequest request, HttpServletResponse response) throws IOException, AlipayApiException {

			// 商户订单号，商户网站订单系统中唯一订单号，必填
			String out_trade_no = UUID.randomUUID().toString() ;
			// 订单名称，必填
			String subject = request.getParameter("subject") ; //new String(request.getParameter("subject").getBytes("ISO-8859-1"), "UTF-8");
			// 付款金额，必填
			String total_amount = request.getParameter("totalPrice") ; //new String(request.getParameter("totalPrice").getBytes("ISO-8859-1"), "UTF-8");
			// 商品描述，可空
			String body = request.getParameter("body") ; // new String(request.getParameter("body").getBytes("ISO-8859-1"), "UTF-8");
			// 超时时间 可空
			String timeout_express = "2m";
			// 销售产品码 必填
			String product_code = "QUICK_WAP_WAY";
			/**********************/
			// SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
			// 调用RSA签名方式
			AlipayClient client = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
					AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
					AlipayConfig.sign_type);
			AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();

			// 封装请求支付信息
			AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
			model.setOutTradeNo(out_trade_no);
			model.setSubject("订单");
			model.setTotalAmount(total_amount);
			model.setBody(body);
			model.setTimeoutExpress(timeout_express);
			model.setProductCode(product_code);
			alipay_request.setBizModel(model);
			// 设置异步通知地址
			alipay_request.setNotifyUrl(AlipayConfig.notify_url);
			// 设置同步地址
			alipay_request.setReturnUrl(AlipayConfig.return_url);

			String callback = request.getParameter("callback");


		User user = (User) request.getSession().getAttribute("user");
		OrdersView orderView = new OrdersView() ;
		orderView.setOrderTime(new Date());
		orderView.setCourseId(Integer.parseInt(request.getParameter("courseId")));
		orderView.setUserId(user.getId());
		orderView.setPrice(Double.valueOf(total_amount));
		orderView.setNumber(out_trade_no);
		orderView.setSubject(body);
		orderView.setName(subject);
		orderView.setState((byte)0); //刚刚生成订单，未支付
		try {
			orderServiceDao.insert(orderView) ;
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("订单生成失败" + e.getMessage());
		}

			// form表单生产
			String form = "";
			try {
				// 调用SDK生成表单
				form = client.pageExecute(alipay_request).getBody();

				response.setContentType("text/html;charset=" + AlipayConfig.charset);
				response.getWriter().write(form);// 直接将完整的表单html输出到页面
				response.getWriter().flush();
				response.getWriter().close();
			} catch (AlipayApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@RequestMapping(value = "/return_url", method = { RequestMethod.GET, RequestMethod.POST })
	public void return_url(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获取支付宝GET过来反馈信息
		PrintWriter out = response.getWriter();
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		// 商户订单号
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
		// 支付宝交易号
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		// 计算得出通知验证结果
		// boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String
		// publicKey, String charset, String sign_type)
		boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
				"RSA2");

		if (verify_result) {// 验证成功
			OrdersView userorder = orderServiceDao.getByNumber(out_trade_no); // 通过订单号找到订单
			userorder.setState((byte)1); //订单支付成功
			orderServiceDao.updateNotNullField(userorder); // 更新订单表

			StringBuffer sf = new StringBuffer();
			sf.append("<script type=\"text/javascript\">");
			sf.append("window.location.href = 'http://127.0.0.1:3000/#/home");
			sf.append("</script>");
			String str = sf.toString();
			out.println(str);
			// out.println(params) ;
			// ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

		} else {
			// 该页面可做页面美工编辑
			// out.clear();
			out.println(false);
		}
	}

	@RequestMapping(value = "/tests", method = { RequestMethod.GET, RequestMethod.POST })
	public void tests(HttpServletResponse response) throws IOException {
		StringBuffer sf = new StringBuffer();
		// sf.append("<html><head><meta http-equiv=\"Content-Type\"
		// content=\"text/html;"+"\"/></head><body>");
		// sf.append("<form id = \"pay_form\" action=\"" + reqUrl
		// + "\" method=\"post\">");
		/*
		 * if (null != hiddens && 0 != hiddens.size()) { Set<Entry<String,
		 * String>> set = hiddens.entrySet(); Iterator<Entry<String, String>> it
		 * = set.iterator(); while (it.hasNext()) { Entry<String, String> ey =
		 * it.next(); String key = ey.getKey(); String value = ey.getValue();
		 * sf.append("<input type=\"hidden\" name=\"" + key + "\" id=\"" + key +
		 * "\" value=\"" + value + "\"/>");
		 * 
		 * <script> window.location.href =
		 * 'http://127.0.0.1:5501/mall/www/index.html#/tab/home' </script> } }
		 */
		// sf.append("</form>");
		// sf.append("</body>");
		sf.append("<script type=\"text/javascript\">");
		// sf.append("document.all.pay_form.submit();");
		sf.append("window.location.href = 'http://127.0.0.1:5501/mall/www/index.html#/tab/home'");
		sf.append("</script>");
		// sf.append("</html>");
		String str = sf.toString();

		response.getWriter().println(sf);
	}
}
