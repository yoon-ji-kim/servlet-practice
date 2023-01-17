package com.douzone.guestbook.dao.test;

import java.util.List;

import com.douzone.guestbook.dao.GuestbookDao;
import com.douzone.guestbook.vo.GuestbookVo;

public class GuestbookDaoTest {

	public static void main(String[] args) {
//		testInsert();
//		testFindAll();
		testDeleteByNoAndPassword();
//		testFindPasswordByNo();
	}

	private static void testDeleteByNoAndPassword() {
		int no = 2;
		String password = "1234";
		new GuestbookDao().deleteByNoAndPassword(no, password);
	}

	private static void testFindPasswordByNo() {
		int no = 2;
		String result = new GuestbookDao().findPasswordByno(no);
		if(!"".equals(result)) {
			System.out.println(result);
		}
	}

	private static void testFindAll() {
		List<GuestbookVo> list = new GuestbookDao().findAll();
		for(GuestbookVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void testInsert() {
		GuestbookVo vo = new GuestbookVo();
		GuestbookDao dao = new GuestbookDao();
		vo.setName("김윤지");
		vo.setPassword("1234");
		vo.setMessage("안녕하세요");
		dao.insert(vo);
	}
	


}
