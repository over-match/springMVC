package com.fastcampus.ch2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// [년월일을 입력하면 해당 요일을 알려주는 프로그램]
@Controller
public class YoilTeller {
//	public static void main(String[] args) { // mian메서드의 매개변수 args로 String 문자열로 값을 받아.. -> 1.입력
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 1. 입력
//		String year = args[0];
//		String month = args[1];
//		String day = args[2];
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		

		// 2. 작업
		int yyyy = Integer.parseInt(year);	// 문자열을 숫자로 변경
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();	// 날짜 세팅
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// 결과가 숫자로 나타남 (1: 일요일, 2: 월요일 ...)
		char yoil = " 일월화수목금토".charAt(dayOfWeek);		
		// 숫자를 다시 문자열로 charAt을 사용하여 숫자을 문자로 뽑아주기
		// " 일월화수목금토" -> 일 앞에 띄어쓰기는 index:0의 위치를 비워두기 위해서다!
	
		// 3. 출력
//		System.out.println(year + "년 " + month + "월 " + day + "일은 ");
//		System.out.println(yoil + "요일입니다.");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");	//한글 인코딩
		try {
			PrintWriter out = response.getWriter();	// response객체에서 브라우져로 출력 스트림을 얻는다.
			out.println(year + "년 " + month + "월 " + day + "일은 ");
			out.println(yoil + "요일입니다.");
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
}
