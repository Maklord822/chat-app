package com.example.chat_app.controller;

import com.example.chat_app.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.send") // mapped to /app/chat.send
    public void sendMessage(Message message) {
        messagingTemplate.convertAndSend("/topic/messages", message);
    }

}
