package com.WebSocket.WebSocket.controlller;

import com.WebSocket.WebSocket.entity.Message;
import com.WebSocket.WebSocket.entity.Room;
import com.WebSocket.WebSocket.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class RoomController {

    @Autowired
    private RoomService roomService;

    //Create Room
    @PostMapping("/room")
    public ResponseEntity<?> createRoom(@RequestBody String roomId) {
        return roomService.createRoom(roomId);
    }

    //Join Room
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId) {
        return roomService.findRoom(roomId);
    }

    //Get Message
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<?> getMessage(@PathVariable String roomId){
        return roomService.getMessages(roomId);
    }


}
