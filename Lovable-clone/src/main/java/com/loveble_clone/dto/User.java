package com.loveble_clone.dto;

import java.time.Instant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
	int id;
	String email;
	String passwordHash;
	String name;
	String avatarUrl;
	Instant createdAt;
	Instant updatedAt;
	Instant deletedAt;
}
