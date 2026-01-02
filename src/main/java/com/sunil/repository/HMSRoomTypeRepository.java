package com.sunil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.model.RoomType;

public interface HMSRoomTypeRepository extends JpaRepository<RoomType, Integer> {

}
