package cn.ymt.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ymt.pojo.User;
import cn.ymt.serviceDao.UserServiceDao;
import cn.ymt.util.UserUtil;
import cn.ymt.util.jsonResult;
import cn.ymt.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserServiceDao userService;

	/**
	 * 此方法为当用户传入手机号码时，通过手机号码去查询
	 *
	 * @param telphone
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/loginOrRegister")
	public jsonResult loginOrRegister(String telphone, String code, HttpServletResponse response, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String a =session.getAttribute("code").toString();
		if (!a.equals(code)) { //判断短信验证码是否相同
			return new jsonResult(false, "短信验证码错误");
		}
		List<UserView> user = userService.findUserByTelphone(telphone);
		if (user != null && user.size() > 0) { //登录
			session.setAttribute("user", user.get(0));
			session.setMaxInactiveInterval(-1);
			return new jsonResult(true, "登录成功");
		} else { //注册
			UserView u = new UserView();
			u.setTelphone(telphone);
			u.setImgUrl("http://www.javacoffee.club/noPicture.svg");
			try {
				userService.insert(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("user", u); //用户保存在session中
			session.setMaxInactiveInterval(-1);
			return new jsonResult(true, "注册成功");
		}
	//	return new jsonResult(true, "登录成功");
	}

	@RequestMapping("/getuser")
	public void getUser() throws Exception{
		List<UserView> userByTelphone = userService.findUserByTelphone("15270054550");
		System.out.println(userByTelphone.toString());
	}

	@RequestMapping("/sendSms")
	public jsonResult sendSms(String telphone, HttpServletResponse response, HttpServletRequest req) {
		/*//签名【类似于公司名字】
		*//**
		 * 类似于： 短信的格式
		 * 	【签名（signName）】内容（message）+一些模板内容
		 * */
		String signName = UserUtil.getSignName();
		//#访问键(阿里云平台注册的)
		String accesskey = UserUtil.getAccessKey();
		//#访问秘钥(阿里云平台注册的)
		String accessSecret = UserUtil.getAccessSecret();
		//推送的模板在（阿里云中申请的）
		String templateCode = "SMS_162197070";
		String phone = telphone.substring(0, 11).trim();
		try {
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accesskey, accessSecret);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
			IAcsClient client = new DefaultAcsClient(profile);
			SendSmsRequest request = new SendSmsRequest();
			Map<String, String> map = new HashMap<String, String>();
			//map.put("message", message);//消息
			int code = (int) ((Math.random() * 9 + 1) * 100000); //产生随机六位数
			req.getSession().setAttribute("code", code);
			req.getSession().setMaxInactiveInterval(60 * 5); //5分钟失效
			String smscode = code + "";
			map.put("code", smscode.trim());
			request.setMethod(MethodType.POST);
			request.setPhoneNumbers(phone);    //接收号码
			request.setSignName(signName);
			//控制台创建的签名名称
			request.setTemplateCode(templateCode);
			// 控制台创建的模板CODE
			request.setTemplateParam(JSON.toJSONString(map));// 短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
			System.out.println(JSON.toJSONString(map));
			SendSmsResponse httpResponse = client.getAcsResponse(request);
			System.out.println(httpResponse.getCode());
			if ("OK".equals(httpResponse.getCode())) {
				return new jsonResult(true, "验证码发送成功");
			} else {
				return new jsonResult(false, "验证码发送失败");
			}
		} catch (Exception e) {
			 e.printStackTrace();
			System.out.println("error_消息发送失败");
			return new jsonResult(false,e.getMessage()) ;
		}
	//	return new jsonResult(true, "验证码发送成功");
	}

	@RequestMapping("/sendSms2")
	public jsonResult sendSms2(String telphone, HttpServletResponse response, HttpServletRequest req) {
		int code = (int) ((Math.random() * 9 + 1) * 100000); //产生随机六位数
		System.out.println(code);
		req.getSession().setAttribute("code", code);
		req.getSession().setMaxInactiveInterval(60 * 5); //5分钟失效
		return new jsonResult(true, "验证码发送成功");
	}
	@RequestMapping("/logOut")
	public void logOut(HttpServletRequest request,HttpServletResponse response){
		 request.getSession().removeAttribute("user");
		//	request.getRequestDispatcher("/").forward(request,response);
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
