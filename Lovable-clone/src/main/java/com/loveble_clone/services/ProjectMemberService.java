package com.loveble_clone.services;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.loveble_clone.dto.ProjectMember;
import com.loveble_clone.dto.member.InviteMemberRequest;
import com.loveble_clone.dto.member.MemberResponse;

public interface ProjectMemberService {

	List<ProjectMember> getProjectMember(Long projectId, Long userId);

	MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

	MemberResponse updateMemberRole(Long projectId, Long memberId, InviteMemberRequest request, Long userId);

	MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);


}
