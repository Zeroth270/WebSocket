package com.WebSocket.WebSocket.controlller;

import com.WebSocket.WebSocket.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
        return roomService.createRoom(roomId);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId){
        return roomService.findRoom(roomId);
    }

}
