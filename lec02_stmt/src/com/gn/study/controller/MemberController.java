package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;
import com.gn.study.view.MemberMenu;

public class MemberController {
	
	public void deleteMember(String id) {
		int result = new MemberDao().deleteMember(id);
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 정보 삭제");
		}else {
			new MemberMenu().displayFail("회원 정보 삭제");
		}
	}
	 
	public void updateMember(String id, String name
			, String email ,String phone) {
		Member m = new Member();
		m.setMemberId(id);
		m.setMemberName(name);
		m.setMemberEmail(email);
		m.setMemberPhone(phone);
		int result = new MemberDao().updateMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 정보 수정");
		}else {
			new MemberMenu().displayFail("회원 정보 수정");
		}
	}
	
	public Member selectByMemberIdPw(String id, String pw) {
		Member m = null;
		m = new MemberDao().selectByMemberIdPw(id,pw);
		return m;
	}
	
	public void insertMember(String memberId,String memberPwd,
			String memberName,String memberEmail,String memberPhone
			,String memberGender) {
		// 전달 받은 값을 Dao에 전달하기 위해서 어딘가에 담기
		// (순수 데이터 가공)
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPwd);
		m.setMemberName(memberName);
		m.setMemberEmail(memberEmail);
		m.setMemberPhone(memberPhone);
		m.setMemberGender(memberGender);		
		int result = new MemberDao().insertMember(m);
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 추가");
		}else {
			new MemberMenu().displayFail("회원 추가");
		}
	}
	
	public void selectMemberAll() {
		List<Member> resultList = new MemberDao().selectMemberAll();
		if(resultList.isEmpty()) {
			new MemberMenu().displayNoData();
		} else {
			new MemberMenu().displayMemberList(resultList);
		}
	}
	
	public void selectByMemberId(String id) {
		Member resultVo = new MemberDao().selectByMemberId(id);
		if(resultVo == null) {
			new MemberMenu().displayNoData();
		} else {
			new MemberMenu().displayMember(resultVo);
		}	
	}
	
	public void selectByMemberName(String name) {
		List<Member> resultList = new MemberDao().selectByMemberName(name);
		if(resultList.isEmpty()) {
			new MemberMenu().displayNoData();
		} else {
			new MemberMenu().displayMemberList(resultList);
		}
	}
	
}
