package com.fastcampus.ch2;
import java.io.IOException;
import java.util.Calendar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// [년월일을 입력하면 해당 요일을 알려주는 프로그램]
@Controller
public class YoilTellerMVC { // http://localhost:8080/getYoilMVC?year=2021&month=10&day=1
	@RequestMapping("/getYoilMVC")
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
//	public String main(int year, int month, int day, Model model) throws IOException {
//	public void main(int year, int month, int day, Model model) throws IOException { // return타입이 없이 requestMapping된 경로로 찾아간다.
	public ModelAndView main(int year, int month, int day) throws IOException { // 자주 사용하지 않음

		// ModelAndView를 생성하고, 기본 뷰를 지정
		ModelAndView mv = new ModelAndView();
		mv.setViewName("yoilError"); // 뷰의 이름을 지정
		
		// 1. 유효성 검사
		if(!isValid(year, month, day)) // valid: 유효성
//			return "yoilError";
			return mv;
		
		// 2. 요일 계산 (작업)
		char yoil = getYoil(year, month, day);		

		// 3-1. 계산한 결과를 model에 저장
//		model.addAttribute("year", year);
//		model.addAttribute("month", month);
//		model.addAttribute("day", day);
//		model.addAttribute("yoil", yoil);
		
		// 3-2. 계산한 결과를 ModelAndView에 저장
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);
		
//		return "yoil"; // /WEB-INF/views/yoil.jsp
		// 4. 결과를 보여줄 view 지정
		mv.setViewName("yoil");
		
		return mv;
	}

	private boolean isValid(int year, int month, int day) { // class 안에서만 사용하기 위해 private
//		return false; // yoilError만 출력 테스트
		return true; 
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();	// 날짜 세팅
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}
}
