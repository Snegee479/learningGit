package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
@Autowired
	StudentDAO dao;
Logger log=Logger.getAnonymousLogger();
@RequestMapping("/insert")
public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	log.info("recieved name and email from front end");
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	Student s=new Student();
	log.info("pojo object created");
	s.setName(name);
	log.info("name is set to the pojo");
	s.setEmail(email);
	log.info("email is set to the pojo");
	Student sd=dao.insert(s);
	log.info("insert method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("status.jsp");
	}
	
	return mv;
}
	

@RequestMapping("/getall")
public ModelAndView getstudents(HttpServletRequest req,HttpServletResponse res) {
	log.info("in get all request");
	ModelAndView mv=new ModelAndView();
	log.info("created mv object");
	List<Student> list=dao.getall();
	log.info("called getall method");
	mv.setViewName("display.jsp");
	log.info("went to jsp");
	mv.addObject("list",list);
	log.info("sent a list to the jsp");
	return mv;
}

@RequestMapping("/edit")
public ModelAndView showEditForm(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
	ModelAndView mv=new ModelAndView();
	log.info("in edit request");
	//int sid=Integer.parseInt(req.getParameter("sid"));
	mv.setViewName("edit.jsp");
	log.info("sent to jsp edit");

	return mv;
}
@SuppressWarnings("null")
@RequestMapping("editStudent")
public ModelAndView editstudent(HttpServletRequest req,HttpServletResponse res) throws IOException {
	log.info("in editstudent request");
	ModelAndView mv=new ModelAndView();
//	PrintWriter pw=res.getWriter();
//	pw.print("hi simplilearn");
//	pw.print(req.getParameter("sid"));
	int sid=Integer.parseInt(req.getParameter("sid"));
	log.info("in editstudent request the value of id is : "+sid);
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	Student student = new Student();
	student.setSid(sid);
	student.setEmail(email);
	student.setName(name);

	log.info("created mv object");
	dao.update(student);
	log.info("called update method");
	mv.setViewName("editStudent.jsp");
	log.info("went to jsp");
	log.info("sent a list to editstudent jsp");
	return mv;
}
@RequestMapping("/delete")
public ModelAndView deletestudent(HttpServletRequest req,HttpServletResponse res) {
	log.info("in get all request");
	ModelAndView mv=new ModelAndView();
	log.info("created mv object");
	int id=Integer.parseInt(req.getParameter("id"));
	dao.deleteByid(id);
	log.info("called deleebyid method");
	mv.setViewName("delete.jsp");
	log.info("went to delete jsp");
	return mv;
}


	
}



