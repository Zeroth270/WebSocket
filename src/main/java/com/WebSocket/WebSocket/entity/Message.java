package com.WebSocket.WebSocket.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Message {

    private String sender;

    private String content;

    private LocalDateTime dateTime;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.dateTime = LocalDateTime.now();
    }
}
