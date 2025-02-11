package com.voting.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.voting.Entity.VotingHistory;

public interface VotingHistoryRepository extends JpaRepository<VotingHistory, Integer> {
}
