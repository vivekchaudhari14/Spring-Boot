package com.loveble_clone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loveble_clone.services.ProjectMemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {
	
	private final ProjectMemberService projectMemberService;
	
}
