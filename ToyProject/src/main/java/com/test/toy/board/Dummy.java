package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.test.toy.DBUtil;

public class Dummy {

	public static void main(String[] args) {
		
		//게시글 더미 생성하기
		
		String sql = "insert into tblBoard (seq, subject, content, id ,regdate, readcount) values (seqBoard.nextVal, ?, ?, ?, default, default)";
		
		//시드 데이터
		String[] subject = { "게시판을", "안녕~", "홍길동입니다.", "자바는", "컴퓨터가", "급하게", "만들어져", "완성", "램이", "부족해", "CPU가", "필요해", "에잇", "진짜!!!", "별로다", "너에게 내가", "비싸 너무", "날씨가", "안 좋아", "휴..", "앗!!", "젠장", "뭐라고하는거야", "뉴스 좀 봐", "시장 왜이래", "떡락이다~~~", "꽉 잡아!!!", "배고프다", "고기", "밥 먹어"};
		
		String content = "내용입니다.";
		
		String[] id = {"hong", "admin", "test", "hoho", "hohoho"};
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		
		try {
			
			conn = DBUtil.open();
			
			stat = conn.prepareStatement(sql);
			
			Random rnd = new Random();
			
			for (int i=0; i<256; i++) {
				
				stat.setString(1, subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)]);
				
				stat.setString(2, content);
				
				stat.setString(3, id[rnd.nextInt(id.length)]);
			
				stat.executeUpdate();
				
				System.out.println(i);
				
			}
			
		} catch(Exception e) {
			System.out.println("Dummy.main");
			e.printStackTrace();
		}
		
	}
	
}
