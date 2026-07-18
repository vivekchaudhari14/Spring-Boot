package com.loveble_clone.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loveble_clone.dto.ProjectMember;
import com.loveble_clone.dto.member.InviteMemberRequest;
import com.loveble_clone.dto.member.MemberResponse;
import com.loveble_clone.services.ProjectMemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {
	
	private final ProjectMemberService projectMemberService;
	
	@GetMapping
	public ResponseEntity<List<ProjectMember>> getProjectMember(@PathVariable Long projectId){
		Long userId = 1L;
		return ResponseEntity.ok(projectMemberService.getProjectMember(projectId,userId));
	}
	
	@PostMapping
	public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId, @ResponseBody InviteMemberRequest request ){
		Long userId =1L;
		return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.inviteMember(projectId,request,userId));
	}	
	
	@PatchMapping("{memberId}")
	public ResponseEntity<MemberResponse> updateMemberRole(@PathVariable Long projectId,
			@PathVariable Long memberId,@ResponseBody InviteMemberRequest request){
		Long userId = 1L;
		return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId,memberId,request,userId));
	}
	
	@DeleteMapping("{memberId}")
	public ResponseEntity<MemberResponse> updateMemberRole(@PathVariable Long projectId ,@PathVariable Long memberId){
		Long userId = 1L; 
		return ResponseEntity.ok(projectMemberService.deleteProjectMember (projectId,memberId,userId));
	}
	
}
