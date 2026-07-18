package com.loveble_clone.services;

import java.util.List;
import com.loveble_clone.dto.subscription.PlanResponse;

public interface PlanService {

	List<PlanResponse> getAllActivePlans();

}
