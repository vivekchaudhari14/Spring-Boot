package com.loveble_clone.services;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.loveble_clone.dto.ProjectMember;
import com.loveble_clone.dto.member.InviteMemberRequest;
import com.loveble_clone.dto.member.MemberResponse;
import com.loveble_clone.dto.member.UpdateMemberRoleRequest;

public interface ProjectMemberService {

	List<MemberResponse> getProjectMember(Long projectId, Long userId);

	MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

	MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId);

	MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);


}
