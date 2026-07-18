package com.loveble_clone.services;

import org.jspecify.annotations.Nullable;

import com.loveble_clone.dto.subscription.UsageTodayResponse;

public interface UsageService {

	UsageTodayResponse getTodayUsageOfUser(Long userId);

}
