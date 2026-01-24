package com.WebSocket.WebSocket.controlller;

import com.WebSocket.WebSocket.entity.Message;
import com.WebSocket.WebSocket.entity.Room;
import com.WebSocket.WebSocket.payLoad.MessageRequest;
import com.WebSocket.WebSocket.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class ChatController {

    @Autowired
    private RoomRepository roomRepository;


    @MessageMapping("/sendMessage/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            @Payload MessageRequest request
    ) {

        Optional<Room> roomOptional = roomRepository.findById(roomId);

        Message message = new Message();

        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setDateTime(LocalDateTime.now());

        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            room.getMessages().add(message);
            roomRepository.save(room);
        }

        return message;
    }
}
