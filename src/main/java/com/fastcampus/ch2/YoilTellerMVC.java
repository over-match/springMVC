package com.fastcampus.ch2;
import java.io.IOException;
import java.util.Calendar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// [������� �Է��ϸ� �ش� ������ �˷��ִ� ���α׷�]
@Controller
public class YoilTellerMVC { // http://localhost:8080/getYoilMVC?year=2021&month=10&day=1
	@RequestMapping("/getYoilMVC")
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
//	public String main(int year, int month, int day, Model model) throws IOException {
//	public void main(int year, int month, int day, Model model) throws IOException { // returnŸ���� ���� requestMapping�� ��η� ã�ư���.
	public ModelAndView main(int year, int month, int day) throws IOException { // ���� ������� ����

		// ModelAndView�� �����ϰ�, �⺻ �並 ����
		ModelAndView mv = new ModelAndView();
		mv.setViewName("yoilError"); // ���� �̸��� ����
		
		// 1. ��ȿ�� �˻�
		if(!isValid(year, month, day)) // valid: ��ȿ��
//			return "yoilError";
			return mv;
		
		// 2. ���� ��� (�۾�)
		char yoil = getYoil(year, month, day);		

		// 3-1. ����� ����� model�� ����
//		model.addAttribute("year", year);
//		model.addAttribute("month", month);
//		model.addAttribute("day", day);
//		model.addAttribute("yoil", yoil);
		
		// 3-2. ����� ����� ModelAndView�� ����
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);
		
//		return "yoil"; // /WEB-INF/views/yoil.jsp
		// 4. ����� ������ view ����
		mv.setViewName("yoil");
		
		return mv;
	}

	private boolean isValid(int year, int month, int day) { // class �ȿ����� ����ϱ� ���� private
//		return false; // yoilError�� ��� �׽�Ʈ
		return true; 
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();	// ��¥ ����
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}
}
