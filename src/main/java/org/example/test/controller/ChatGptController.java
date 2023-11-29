package org.example.test.controller;

import org.example.test.service.IChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatGpt")
public class ChatGptController {
    final IChatGptService chatGptService;
    @Autowired
    public ChatGptController(IChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }
    @PostMapping(value = "/test")
    public Object test(@RequestParam("prompt") String prompt) throws Exception {
        return chatGptService.test(prompt);
    }
}
