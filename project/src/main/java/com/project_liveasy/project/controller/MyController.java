package com.project_liveasy.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project_liveasy.project.entity.loads;
import com.project_liveasy.project.service.LoadService;

@RestController
public class MyController {
	@Autowired
	private LoadService loadservice;
	
	//Default Function
	@GetMapping("/home")
	public String home() {
		return "Hello World!";
	}
	@GetMapping("/load")
	public List<loads> get(){
		return this.loadservice.get();
	}
	
	//Getting all loads
	@GetMapping("/load")
	public List<loads> GetAll(@RequestParam String  shipperId){
		return this.loadservice.GetAll(Integer.parseInt(shipperId));
	}
	
	//getting Specific load
	@GetMapping("/load/{id}")
	public Optional<loads> GetOne(@PathVariable String id){
		return this.loadservice.GetOne(Integer.parseInt(id));
	}
	
	//adding a load
	@PostMapping("/load")
	public ResponseEntity<String> Add(@RequestBody loads load) {
		try {
			this.loadservice.Add(load);
			return new ResponseEntity<>("Response:loads details added successfully \r\n",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Response: an error occurred while adding load details",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Updating a load
	@PutMapping("/load/{id}")
	public loads Udpate(@PathVariable String id,@RequestBody loads load) {
		return this.loadservice.Update(Integer.parseInt(id),load);
	}
	
	//Deleting a load
	@DeleteMapping("/load/{id}")
	public ResponseEntity<HttpStatus> Delete(@PathVariable String id){
		try {
			this.loadservice.Delete(Integer.parseInt(id));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
