package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cg.domain.Reward;

public interface IDaoReward extends JpaRepository<Reward,Long> {
	@Transactional
	@Query("select r from Reward r where r.user.userId=?")
	public Reward getReward(String userid);
}
