package com.loveble_clone.services.impl;

import java.util.List;

import com.loveble_clone.dto.member.InviteMemberRequest;
import com.loveble_clone.dto.member.MemberResponse;
import com.loveble_clone.dto.member.UpdateMemberRoleRequest;
import com.loveble_clone.services.ProjectMemberService;

public class ProjectMemberServiceImpl implements ProjectMemberService{

	@Override
	public List<MemberResponse> getProjectMember(Long projectId, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request,
			Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
