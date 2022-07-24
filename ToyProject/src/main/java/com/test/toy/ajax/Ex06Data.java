package com.test.toy.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/ex06data.do")
public class Ex06Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ex06Data.java
		
		String buseo = req.getParameter("buseo");
		
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<BuseoDTO> list = dao.listInsa(buseo);
		
		
		//ArrayList<BuseoDTO> -> JSON 변환
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		String temp = "";
		
		temp += "[";
		
		for (BuseoDTO dto : list) {
			
			temp += "{";
			
			temp += String.format("\"num\": %s,", dto.getNum());
			temp += String.format("\"name\": \"%s\",", dto.getName());
			temp += String.format("\"jikwi\": \"%s\",", dto.getJikwi());
			temp += String.format("\"tel\": \"%s\",", dto.getTel());
			temp += String.format("\"city\": \"%s\"", dto.getCity());
					
			temp += "},";
			
		}
		
		temp = temp.substring(0, temp.length() - 1); //마지막 , 제거
			
		temp += "]";
		
		writer.print(temp);
		
		writer.close();
		
		//ex06data.do?buseo=기획부
				
		
		/*
		 	[
				{
					"num": 1001,
					"name": "홍길동",
					"jikwi": "과장",
					"tel": "010-1234-5678",
					"city": "서울"
				},
				{
					"num": 1001,
					"name": "홍길동",
					"jikwi": "과장",
					"tel": "010-1234-5678",
					"city": "서울"
				},
				{
					"num": 1001,
					"name": "홍길동",
					"jikwi": "과장",
					"tel": "010-1234-5678",
					"city": "서울"
				}
		 	]
		 	
		 	
		 */
		
		

	}

}
