package com.loveble_clone.dto.subscription;

public record PlanResponse(Long id,
			String name,	
			Integer maxProjects,
			Integer maxTokensPerDay,
			Integer maxPreviews,// max number id previews allowed per plan  
			Boolean unlimitedAi, // unlimited access to LLM ignore maxTokenperDay if True;
			String price) {

}
