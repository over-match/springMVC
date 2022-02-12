package com.fastcampus.ch2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// [������� �Է��ϸ� �ش� ������ �˷��ִ� ���α׷�]
@Controller
public class YoilTeller {
//	public static void main(String[] args) { // mian�޼����� �Ű����� args�� String ���ڿ��� ���� �޾�.. -> 1.�Է�
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 1. �Է�
//		String year = args[0];
//		String month = args[1];
//		String day = args[2];
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		

		// 2. �۾�
		int yyyy = Integer.parseInt(year);	// ���ڿ��� ���ڷ� ����
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();	// ��¥ ����
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// ����� ���ڷ� ��Ÿ�� (1: �Ͽ���, 2: ������ ...)
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);		
		// ���ڸ� �ٽ� ���ڿ��� charAt�� ����Ͽ� ������ ���ڷ� �̾��ֱ�
		// " �Ͽ�ȭ�������" -> �� �տ� ����� index:0�� ��ġ�� ����α� ���ؼ���!
	
		// 3. ���
//		System.out.println(year + "�� " + month + "�� " + day + "���� ");
//		System.out.println(yoil + "�����Դϴ�.");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");	//�ѱ� ���ڵ�
		try {
			PrintWriter out = response.getWriter();	// response��ü���� �������� ��� ��Ʈ���� ��´�.
			out.println(year + "�� " + month + "�� " + day + "���� ");
			out.println(yoil + "�����Դϴ�.");
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
}
