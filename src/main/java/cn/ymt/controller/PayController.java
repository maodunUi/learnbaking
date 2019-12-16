package cn.ymt.controller;


import cn.ymt.pojo.Order;
import cn.ymt.pojo.User;
import cn.ymt.serviceDao.OrderServiceDao;
import cn.ymt.serviceDao.ShopcartServiceDao;
import cn.ymt.util.AlipayConfig;
import cn.ymt.view.OrderView;
import cn.ymt.view.ShopcartView;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/pay")
public class PayController {
	@Autowired
	private OrderServiceDao orderServiceDao ;
	@Autowired
	private ShopcartServiceDao shopcartServiceDao ;
	//点击付款跳转到支付宝付款页面 传number totalPrice subject body courseId
	@RequestMapping(value = "/toPayPage", method = { RequestMethod.GET, RequestMethod.POST })
	public void toPayPage(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		String out_trade_no = null;
		String total_amount = null ;
		String subject = null ;
		String body = null ;
		try {
			 out_trade_no = new String(request.getParameter("number").getBytes("ISO-8859-1"),"UTF-8");
			 total_amount = new String(request.getParameter("totalPrice").getBytes("ISO-8859-1"),"UTF-8");
			 subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"),"UTF-8"); //商品名
			 body = new String(request.getParameter("body").getBytes("ISO-8859-1"),"UTF-8"); //描述
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			out.print("参数得到失败，或者字符编码出错");
		}
		User user = (User) request.getSession().getAttribute("user");
		OrderView orderView = new OrderView() ;
		orderView.setOrderTime(new Date());
		orderView.setCourseId(Integer.parseInt(request.getParameter("courseId")));
		orderView.setUserId(user.getId());
		orderView.setPrice(Double.valueOf(total_amount));
		orderView.setSubject(body);
		orderView.setName(subject);
		orderView.setState((byte)0); //刚刚生成订单，未支付
		try {
			orderServiceDao.insert(orderView) ;
		} catch (Exception e) {
			e.printStackTrace();
			out.print("订单生成失败" + e.getMessage());
		}
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
				+ "\"total_amount\":\""+ total_amount +"\","
				+ "\"subject\":\""+ subject +"\","
				+ "\"body\":\""+ body +"\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		String result = null;
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
			out.print(e.getMessage());
		}
		response.setContentType("text/html;charset=" + AlipayConfig.charset);
		out.println(result);
	}


	//用户支付后的跳转的同步页面
	@RequestMapping(value = "/return_url", method = { RequestMethod.GET, RequestMethod.POST })
	public void return_url(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");//商户订单号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");//支付宝交易号
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");//付款金额
			// 请在这里加上商户的业务逻辑程序代码
			OrderView userorder = orderServiceDao.getByNumber(out_trade_no); // 通过订单号找到订单
			userorder.setState((byte)1); //订单支付成功
			orderServiceDao.updateNotNullField(userorder); // 更新订单表

			//out.println("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);
			//return new jsonResult(true,"支付成功") ;
			response.sendRedirect("/");
		}else {
			//out.println("验签失败");
			//return new jsonResult(true,"支付成功") ;
		}

	}
}
