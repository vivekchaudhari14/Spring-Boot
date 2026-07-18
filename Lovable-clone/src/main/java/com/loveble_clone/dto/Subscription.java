package com.loveble_clone.dto;

import java.time.Instant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level =AccessLevel.PRIVATE)
public class Subscription {
	Long  id;
	User user;
	Plan plan;
	SubscripationStatus status;
	String stripeCustomerId;
	String stripeSubscriptionId;
	Instant currentPeriodStart;
	Instant currentPeriodTime;
	Boolean cancelAtPeriodEnd = false;
	
	Instant createdAt;
	Instant updatedAt;
	
}
