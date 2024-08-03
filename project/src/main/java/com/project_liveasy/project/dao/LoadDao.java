package com.project_liveasy.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_liveasy.project.entity.loads;

public interface LoadDao extends JpaRepository<loads,Integer> {
	 List<loads> findByshipperId (int shipperId);
}
