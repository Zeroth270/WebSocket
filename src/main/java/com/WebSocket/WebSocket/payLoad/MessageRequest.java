package com.WebSocket.WebSocket.payLoad;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageRequest {

    private String Sender;

    private String content;

    private String roomId;

}
