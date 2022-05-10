package com.example.bankingsystem.repo;

import com.example.bankingsystem.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, UUID> {
    List<Profile> findProfileByUuid(UUID uuid);


}
