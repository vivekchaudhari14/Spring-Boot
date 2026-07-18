package com.loveble_clone.services;

import java.util.List;
import com.loveble_clone.dto.project.FileContentResponse;
import com.loveble_clone.dto.project.FileNode;

public interface FileService {


	List<FileNode> getFileTree(Long projectId, Long userId);

	 FileContentResponse getFileContent(Long projectId, String path, Long userId);
	
}
