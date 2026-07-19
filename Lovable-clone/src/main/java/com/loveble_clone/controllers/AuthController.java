package com.loveble_clone.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loveble_clone.dto.auth.AuthResponse;
import com.loveble_clone.dto.auth.LoginRequest;
import com.loveble_clone.dto.auth.SignupRequest;
import com.loveble_clone.dto.auth.UserProfileResponse;
import com.loveble_clone.services.AuthService;
import com.loveble_clone.services.UserService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {
	
	 AuthService authService;
	 UserService userService;
	
	@PostMapping("signup")
	public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {
		return ResponseEntity.ok(authService.signup(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest request){
		return ResponseEntity.ok(authService.login(request));
	}
	
	@GetMapping("/me")
	public ResponseEntity<UserProfileResponse> getProfile(){
		Long userId = 1L;
		return ResponseEntity.ok(userService.getProfile(userId));
	}
}
