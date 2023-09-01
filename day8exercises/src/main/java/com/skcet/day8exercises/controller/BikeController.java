package com.skcet.day8exercises.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.day8exercises.entity.BikeEntity;
import com.skcet.day8exercises.service.BikeService;


@RestController
@RequestMapping("apibike")
public class BikeController {
	@Autowired
	private BikeService bikeService;
	
	@PostMapping(path="/savebike")
	public BikeEntity saveBikes(@RequestBody BikeEntity c) {
		return bikeService.saveBikes(c);
	}
	
	   //JPQL
	
		@GetMapping("/getBikesUsingJPQL")
		public List<BikeEntity> getAllBikesUsingJPQL(){
			return bikeService.getAllBikesUsingJPQL();
		}
		
		@PutMapping("/bikes/update/{bikeName}/{ownerName}")
		public ResponseEntity<String> updateBikeByName(@PathVariable String bikeName, @PathVariable String ownerName) {
			return new ResponseEntity<String>(bikeService.updateBikeByName(bikeName, ownerName)+" record(s) updated.", HttpStatus.OK);
		}

}
