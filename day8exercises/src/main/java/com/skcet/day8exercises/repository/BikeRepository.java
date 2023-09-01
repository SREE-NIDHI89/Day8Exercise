package com.skcet.day8exercises.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skcet.day8exercises.entity.BikeEntity;

@Repository
public interface BikeRepository extends JpaRepository<BikeEntity,Integer>{
	 //JPQL 

    @Query("select b from BikeEntity b")
   public List<BikeEntity> getAllBikesUsingJPQL();
    
    
    @Transactional
	@Modifying
	@Query("UPDATE BikeEntity SET bikeName = :bikeName WHERE ownerName = :ownerName")
	Integer updateBikeByName(String bikeName, String ownerName);
}
