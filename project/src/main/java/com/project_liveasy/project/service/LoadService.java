package com.project_liveasy.project.service;

import java.util.List;
import java.util.Optional;

import com.project_liveasy.project.entity.loads;


public interface LoadService {
	public List<loads> get();
	
	public List<loads> GetAll(int shipperId);
	
	public Optional<loads> GetOne(int id);
	
	public void Add(loads load);
	
	public loads Update(int id,loads load);
	
	public void Delete(int id);
}
