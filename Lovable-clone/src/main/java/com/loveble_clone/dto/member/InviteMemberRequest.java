package com.loveble_clone.dto.member;

import com.loveble_clone.dto.ProjectRole;

public record InviteMemberRequest(String email,ProjectRole role) {
	
}
