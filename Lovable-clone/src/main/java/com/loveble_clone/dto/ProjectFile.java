package com.loveble_clone.dto;

import java.time.Instant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@FieldDefaults(level =AccessLevel.PRIVATE)
public class ProjectFile {
	Long id;
	Project project;
	String path;
	String miniioObjectKey;
	Instant createdAt;
	Instant updatedAt;
	User createdBy;
	User updatedBy;
}
