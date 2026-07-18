package com.loveble_clone.services;

import java.util.concurrent.Flow.Subscription;

import org.jspecify.annotations.Nullable;

import com.loveble_clone.dto.subscription.CheckoutRequest;
import com.loveble_clone.dto.subscription.CheckoutResponse;
import com.loveble_clone.dto.subscription.PortalResponse;

public interface SubscripationService {

	Subscription getCurrentSubscription(Long userId);

	CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

	PortalResponse openCustomerPortal(Long userId);

	
}
