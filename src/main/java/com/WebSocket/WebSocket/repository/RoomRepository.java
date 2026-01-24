package com.WebSocket.WebSocket.repository;

import com.WebSocket.WebSocket.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

    Room findRoomById(String roomId);
}
