package com.fastcampus.ch2;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeader {
	@RequestMapping("/requestHeader")
	public void main(HttpServletRequest request) {
		
		Enumeration<String> e = request.getHeaderNames();

		// while 반복문으로 header를 하나씩 찍어본 것
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name + ":" + request.getHeader(name));
		}
	}
}
