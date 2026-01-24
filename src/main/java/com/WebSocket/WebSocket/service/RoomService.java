package com.WebSocket.WebSocket.service;

import com.WebSocket.WebSocket.entity.Message;
import com.WebSocket.WebSocket.entity.Room;
import com.WebSocket.WebSocket.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;


    //Create Room
    public ResponseEntity<?> createRoom(String roomId) {
        Optional<Room> room1 = roomRepository.findById(roomId);
         if (room1.isPresent()){
             return ResponseEntity
             .badRequest()
             .body("Room Already Exists");
         }
        Room room = new Room();
        room.setId(roomId);
        Room saveRoom = roomRepository.save(room);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(room);
    }


    //Get Room
    public ResponseEntity<?> findRoom(String roomId) {
        Optional<Room> byRoomId = roomRepository.findById(roomId);
        if (byRoomId.isEmpty()) {
            return ResponseEntity.badRequest().body("Room Not Found!");
        }
        System.out.println("RoomId received: [" + roomId + "]");
        System.out.println("Exists: " + roomRepository.existsById(roomId));
        return ResponseEntity.ok(byRoomId);
    }


    //Get Messages
    public ResponseEntity<?> getMessages(String roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isEmpty()){
            return ResponseEntity.badRequest().body("Room Not Found");
        }
        List<Message> message = room.get().getMessages();
        return ResponseEntity.ok(message);
    }
}
