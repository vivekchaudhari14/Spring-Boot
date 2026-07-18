package com.loveble_clone.dto.member;

import java.time.Instant;

import com.loveble_clone.dto.ProjectRole;

public record MemberResponse(Long userId,String email, 
		String name,String avatarUrl
		,ProjectRole role,Instant invitedAt) {
	
}
