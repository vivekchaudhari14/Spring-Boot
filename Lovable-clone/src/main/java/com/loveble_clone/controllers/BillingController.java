package com.loveble_clone.controllers;

import java.util.List;
import java.util.concurrent.Flow.Subscription;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loveble_clone.dto.subscription.CheckoutRequest;
import com.loveble_clone.dto.subscription.CheckoutResponse;
import com.loveble_clone.dto.subscription.PlanResponse;
import com.loveble_clone.dto.subscription.PortalResponse;
import com.loveble_clone.services.PlanService;
import com.loveble_clone.services.SubscripationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BillingController {
	
	private final PlanService planService;
	private final SubscripationService subscripationService;
	
	@GetMapping("/api/plans")
	public ResponseEntity<List<PlanResponse>> getAllPlans(){
		return ResponseEntity.ok(planService.getAllActivePlans());
	}
	
	@GetMapping("/api/me/subscription")
	public ResponseEntity<SubscripationResponse> getMySubscripation(){
		Long userId = 1L;
		return ResponseEntity.ok(subscripationService.getCurrentSubscription(userId));
	}
	
	@PostMapping("/api/stripe/checkout")
	public ResponseEntity<CheckoutResponse> createCheckoutResponse(@RequestBody CheckoutRequest request ){
		Long userId = 1L;
		return ResponseEntity.ok(subscripationService.createCheckoutSessionUrl(request,userId));
	}
	
	@PostMapping("/api/stripe/portal")
	public ResponseEntity<PortalResponse> openCustomerPortal(){
		Long userId = 1L;
		return ResponseEntity.ok(subscripationService.openCustomerPortal(userId));
	}
}
