package com.loveble_clone.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loveble_clone.dto.auth.AuthResponse;
import com.loveble_clone.dto.auth.LoginRequest;
import com.loveble_clone.dto.auth.SignupRequest;
import com.loveble_clone.dto.auth.UserProfileResponse;
import com.loveble_clone.services.AuthService;
import com.loveble_clone.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/auth")
public class AuthController {
	
	private AuthService authService;
	private UserService userService;
	
	@PostMapping("signup")
	public ResponseEntity<AuthResponse> signup(SignupRequest request) {
		return ResponseEntity.ok(authService.signup(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login (LoginRequest request){
		return ResponseEntity.ok(authService.login(request));
	}
	
	@GetMapping("/me")
	public ResponseEntity<UserProfileResponse> getProfile(){
		Long userId = 1L;
		return ResponseEntity.ok(userService.getProfile(userId));
	}
}
