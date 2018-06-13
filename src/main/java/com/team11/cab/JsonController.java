package com.team11.cab;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team11.cab.model.Member;
import com.team11.cab.service.MemberService;


@Controller
@RequestMapping(value = "/json")
public class JsonController {

	@Autowired
	private MemberService mService;
	
	
	@RequestMapping(value = "/showmember")
	@ResponseBody
	public ArrayList<Member> jsonMembers() 
	{
		return mService.findAllMember();
	}

}
