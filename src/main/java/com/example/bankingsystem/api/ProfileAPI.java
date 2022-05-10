package com.example.bankingsystem.api;

import com.example.bankingsystem.entity.Profile;
import com.example.bankingsystem.services.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileAPI {

    private ProfileService profileService;

    public ProfileAPI(ProfileService profileService) {
        this.profileService = profileService;
    }
    @GetMapping("/api/profile")
    public List<Profile> getAll(){
        return profileService.getAll();
    }

}
