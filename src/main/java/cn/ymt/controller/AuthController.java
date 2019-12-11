package cn.ymt.controller;

import cn.ymt.util.jsonResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
@CrossOrigin
@RestController
@RequestMapping("/AuthController")
public class AuthController {
    @RequestMapping("/auth")
    public jsonResult auth(HttpServletRequest request){
        return new jsonResult(false,"用户未登录") ;
    }
}
