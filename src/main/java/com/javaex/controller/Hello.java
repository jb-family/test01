package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class Hello{

	@RequestMapping( "/hello")
	public String hello(){
		System.out.println("/hellospring/hello");
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("/hellospring/writeForm");
		return "/WEB-INF/views/writeForm.jsp";
				
	}
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String wirte(@RequestParam ("name") String name,
						@RequestParam ("hp") String hp,
						@RequestParam ("company") String company) {

		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		//Vo만들기
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println("personVo = "+personVo);
		//Dao만들기
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
}
