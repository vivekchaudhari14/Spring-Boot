package com.loveble_clone.dto.subscription;

public record UsageTodayResponse(Integer tokenUsed,Integer tokenLimit,
		Integer previewRunning,Integer previewLimit) {

}
