package com.loveble_clone.services;


import org.jspecify.annotations.Nullable;

import com.loveble_clone.dto.auth.AuthResponse;
import com.loveble_clone.dto.auth.LoginRequest;
import com.loveble_clone.dto.auth.SignupRequest;

public interface AuthService {

	AuthResponse signup(SignupRequest request);
	AuthResponse login(LoginRequest request);

}
