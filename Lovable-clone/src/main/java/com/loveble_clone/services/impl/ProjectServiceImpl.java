package com.loveble_clone.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loveble_clone.dto.project.ProjectRequest;
import com.loveble_clone.dto.project.ProjectResponse;
import com.loveble_clone.dto.project.ProjectSummaryResponse;
import com.loveble_clone.services.Projectservice;

@Service
public class ProjectServiceImpl implements Projectservice{

	@Override
	public List<ProjectSummaryResponse> getUserProjects(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectResponse getUserProjectById(Long id, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectResponse createProject(ProjectRequest request, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void softDelete(Long id, Long userId) {
		// TODO Auto-generated method stub
		
	}

}
