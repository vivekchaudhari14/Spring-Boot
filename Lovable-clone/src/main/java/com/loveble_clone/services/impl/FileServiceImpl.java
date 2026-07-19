package com.loveble_clone.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loveble_clone.dto.project.FileContentResponse;
import com.loveble_clone.dto.project.FileNode;
import com.loveble_clone.services.FileService;

@Service 
public class FileServiceImpl implements FileService {

	@Override
	public List<FileNode> getFileTree(Long projectId, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
