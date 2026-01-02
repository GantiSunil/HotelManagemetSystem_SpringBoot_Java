package com.sunil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil.model.Rooms;

@Repository 
public interface HMSRoomsRepository extends JpaRepository<Rooms, Integer> {

}
