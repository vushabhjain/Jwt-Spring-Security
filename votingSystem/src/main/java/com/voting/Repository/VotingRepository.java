package com.voting.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.voting.Entity.Voting;

public interface VotingRepository extends JpaRepository<Voting, Integer> {
}
