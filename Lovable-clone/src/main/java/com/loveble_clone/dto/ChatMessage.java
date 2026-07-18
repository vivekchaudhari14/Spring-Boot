package com.loveble_clone.dto;

import java.time.Instant;

public class ChatMessage {
	Long id;
	ChatSession chatSession;
	String content;
	MessageRole role;
	String toolCalls;
	Integer tokenUsed;
	Instant createdAt;
	
}
