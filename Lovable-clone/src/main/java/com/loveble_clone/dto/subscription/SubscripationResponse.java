package com.loveble_clone.dto.subscription;

import java.time.Instant;

public record SubscripationResponse(PlanResponse plan,String status,
		Instant periodEnd,Long tokensUsedThisCycle) {

}
