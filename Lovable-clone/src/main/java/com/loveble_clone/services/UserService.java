package com.loveble_clone.services;

import com.loveble_clone.dto.auth.UserProfileResponse;

public interface UserService {


	UserProfileResponse getProfile(Long userId);
 
}
 