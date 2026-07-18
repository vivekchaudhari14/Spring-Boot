package com.loveble_clone.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level =AccessLevel.PRIVATE)
public class Plan {
	Long id;
	String name;
	String stripePriceId;
	Integer maxProjects;
	Integer maxTokensPerDay;
	Integer maxPreviews; // max number id previews allowed per plan  
	Boolean unlimitedAi; // unlimited access to LLM ignore maxTokenperDay if True;
	Boolean active;
}
