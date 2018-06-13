package com.team11.cab.service;

import java.util.ArrayList;
import com.team11.cab.model.Member;

public interface MemberService {

	ArrayList<Member> findAllMember();
	public Member findMemberByUsername(String username);
	public void saveMember(Member member);
	
	
}
