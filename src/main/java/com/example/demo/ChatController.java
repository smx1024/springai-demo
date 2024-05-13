package com.example.demo;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;

import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


import java.util.Map;

@RestController
public class ChatController {
    //日志打印
    private final static Logger Log =
            LoggerFactory.getLogger(ChatController.class);

    //注入OpenAiChatClient
    @Autowired
    private OpenAiChatClient chatClient;


    @GetMapping("/ai/generate")
    public Map generate(@RequestParam(value = "message", defaultValue = "给我讲个笑话") String message) {

        Log.info("发送的消息是:{}", message);
        String result = chatClient.call(message);
        Log.info("返回的消息是:{}", result);
        return Map.of("generation", result);
    }


    @GetMapping(value = "/ai/generateStream", produces = "text/event-stream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "给我讲个笑话") String message) {
        Log.info("发送的消息是:{}", message);
        Prompt prompt = new Prompt(new UserMessage(message));
        System.out.println(chatClient.stream(prompt));
        return chatClient.stream(prompt);
    }
}
