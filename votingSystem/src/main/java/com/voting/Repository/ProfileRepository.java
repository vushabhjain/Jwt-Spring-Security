package com.voting.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.voting.Entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
