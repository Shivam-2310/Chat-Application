package com.shivam.chat.chat;

import com.shivam.chat.ai.OllamaService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final OllamaService ollamaService;
    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(OllamaService ollamaService, SimpMessagingTemplate messagingTemplate) {
        this.ollamaService = ollamaService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        String sessionId = headerAccessor.getSessionId();

        if (chatMessage.getContent().startsWith("@meta")) {
            String prompt = chatMessage.getContent().replaceFirst("@meta", "").trim();
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
            String ollamaResponse = ollamaService.sendPromptToOllama(prompt);
            ChatMessage ollamaMessage = new ChatMessage();
            ollamaMessage.setType(MessageType.CHAT);
            ollamaMessage.setContent(ollamaResponse);
            ollamaMessage.setSender("Meta AI");
            messagingTemplate.convertAndSend("/topic/public", ollamaMessage);
            return null;
        }

        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
