package com.project_liveasy.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_liveasy.project.dao.LoadDao;
import com.project_liveasy.project.entity.loads;
@Service
public class LoadServiceImpl implements LoadService{
//	List<loads> list;
	@Autowired
	private LoadDao loaddao;
	
	public LoadServiceImpl() {
//		list=new ArrayList();
//		list.add(new loads(1,"Nagar","Jaipur","pharma","bulk",5,2300,"NA",12321, "11-05-2003"));
//		list.add(new loads(2,"Mumbai","Latur","food","bulk",2,200,"NA",44321, "17-05-2013"));
	}
	@Override
	public List<loads> GetAll(int shipperId) {
//		List<loads> l=new ArrayList();
//		for(loads c :list) {
//			if(c.getShipperId()==shipperId) {
//				l.add(c);
//			}
////	}
		
		return loaddao.findByshipperId(shipperId);
	}
	@Override
	public Optional<loads> GetOne(int id) {
//		loads c=null;
//		for(loads l:list) {
//			if(l.getId()==id) {
//				c=l;
//				break;
//			}
//		}
		return loaddao.findById(id);
	}
	@Override
	public void Add(loads load) {
//		list.add(load);
		loaddao.save(load);
	}
	@Override
	public loads Update(int id,loads load) {
//		loads l=GetOne(id);
//		
//		l.setComment(load.getComment());
//		l.setDate(load.getDate());
//		l.setLoadingPoint(load.getLoadingPoint());
//		l.setNoOfTrucks(load.getNoOfTrucks());
//		l.setProductType(load.getProductType());
//		l.setShipperId(load.getShipperId());
//		l.setTruckType(load.getTruckType());
//		l.setUnloadingPoint(load.getUnloadingPoint());
//		l.setWeight(load.getWeight());
//		
		return loaddao.save(load);
	}
	@Override
	public void Delete(int id) {
//		list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		loaddao.deleteById(id);
	}
	@Override
	public List<loads> get() {
		return loaddao.findAll();
	}
	
}
