package com.voting.Repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.voting.Entity.ElectionYear;

public interface ElectionYearRepository extends JpaRepository<ElectionYear, Integer> {
}
