package com.loveble_clone.services.impl;

import java.util.concurrent.Flow.Subscription;

import org.springframework.stereotype.Service;

import com.loveble_clone.dto.subscription.CheckoutRequest;
import com.loveble_clone.dto.subscription.CheckoutResponse;
import com.loveble_clone.dto.subscription.PortalResponse;
import com.loveble_clone.services.SubscripationService;

@Service
public class SubscripationServiceImpl implements SubscripationService{

	@Override
	public Subscription getCurrentSubscription(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PortalResponse openCustomerPortal(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
