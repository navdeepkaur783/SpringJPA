package com.example.bankingsystem.services;

import com.example.bankingsystem.entity.Profile;
import com.example.bankingsystem.repo.ProfileRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileService {
    private ProfileRepo profileRepo;


    public ProfileService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

//    public Profile createProfile(Profile profile){
//        return profileRepo.save(profile);
//    }

    public Optional<Profile> getById(UUID uuid){
        return profileRepo.findById(uuid);
    }
    public List<Profile> getAll(){
        return profileRepo.findAll();
    }
}
