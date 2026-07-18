package com.loveble_clone.services;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.loveble_clone.dto.project.ProjectResponse;
import com.loveble_clone.dto.project.ProjectRequest;
import com.loveble_clone.dto.project.ProjectSummaryResponse;

public interface Projectservice {
	List<ProjectSummaryResponse> getUserProjects(Long userId);

	ProjectResponse getUserProjectById(Long id, Long userId);

	ProjectResponse createProject(ProjectRequest request, Long userId);

	ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

	void softDelete(Long id, Long userId);
}
