package com.WebSocket.WebSocket.service;

import com.WebSocket.WebSocket.entity.Room;
import com.WebSocket.WebSocket.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public ResponseEntity<?> createRoom(String roomId){
        //if exist
//        if (roomRepository.findById(roomId).isPresent()){
//            return ResponseEntity
//                    .badRequest()
//                    .body("Room Already Exists");
//        }

        //if not exists
        Room room = new Room();
        room.setId(roomId);
        Room saveRoom = roomRepository.save(room);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(room);
    }

    public ResponseEntity<?> findRoom(String roomId) {
        Room byRoomId = roomRepository.findByRoomId(roomId);

        roomId = roomId.trim();

        if (byRoomId == null){
            return ResponseEntity.badRequest().body("Room Not Found!");
        }
        return ResponseEntity.ok(roomId);
    }
}
