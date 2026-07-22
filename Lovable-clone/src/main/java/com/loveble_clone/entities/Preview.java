package com.loveble_clone.dto;

import java.time.Instant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Preview {
	Long id;
	Project project;
	String nameSpace;
	String podName;
	String previewUrl;
	
	PreviewStatus status;
	
	Instant startedAt;
	Instant terminatedAt;
	
	Instant createdAt;
	
}
