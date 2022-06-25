package com.example.demo;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class StudentController {
@Autowired
	Studentdao dao;

Logger log=Logger.getAnonymousLogger();
@ResponseBody
@RequestMapping("/login")
public String login(HttpServletRequest request,HttpServletResponse res,@RequestParam("spassword") String spassword) throws IOException {
	String suser=request.getParameter("suser");
	log.info("inside the request mapping of login");
	log.info("object from user"+dao.findbyuser(suser));
	Student ss=dao.findbypassword(spassword);
	HttpSession session = request.getSession();
	session.setAttribute("ss", ss);
	log.info("object from password"+dao.findbypassword(spassword));
	if(dao.findbyuser(suser).equals(dao.findbyuser(suser))) {
		log.info("validation of the user is successfull");
		log.info(((Student)session.getAttribute("ss")).getSuser()+"this is what we need to check");
		//req.setAttribute( user, user);
		res.sendRedirect("success.jsp");
		return "Login is successfull";
	}
	else {
		log.info("failed");
	return "login failed ! check the credentials or register first";
	}
	
}
@ResponseBody
@RequestMapping("/register")
public String register(HttpServletRequest req,HttpServletResponse res)
{
	
	log.info("into the register mapping");
	String suser=req.getParameter("suser");
	String spassword=req.getParameter("spassword");
	String semail=req.getParameter("semail");
	log.info("data set");
	RestTemplate rest=new RestTemplate();
	String url="http://localhost:8082/register-user/"+suser+"/"+spassword+"/"+semail;
	log.info(url);
	rest.getForObject(url,String.class);
	log.info("went to register ms");
	return "success";
}
	
}



