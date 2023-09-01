package com.skcet.day8exercises.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.skcet.day8exercises.entity.BikeEntity;
import com.skcet.day8exercises.repository.BikeRepository;



@Service
public class BikeService {
	@Autowired
	private BikeRepository bikeRepository;
	
	public BikeEntity saveBikes(BikeEntity b) {
		return bikeRepository.save(b);
	}
	
	   //JPQL
	
		public List<BikeEntity> getAllBikesUsingJPQL(){
			return bikeRepository.getAllBikesUsingJPQL();
		}
		public ResponseEntity<String> updateBikeByName(@PathVariable String bikeName, @PathVariable String ownerName) {
			return new ResponseEntity<String>(bikeRepository.updateBikeByName(bikeName, ownerName)+" record(s) updated.", HttpStatus.OK);
		}

}
