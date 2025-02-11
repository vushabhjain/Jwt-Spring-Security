package com.voting.Repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.voting.Entity.Appeal;

public interface AppealRepository extends JpaRepository<Appeal, Integer> {
}
