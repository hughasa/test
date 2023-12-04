package org.example.test.service.impl;

import org.example.test.service.IChatGptService;
import org.example.test.util.OpenAIAPIUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatGptServiceImpl implements IChatGptService {
    @Value("${chatGpt.apiKey}")
    String apiKey;
    @Override
    public String test(String prompt) throws Exception {
        return OpenAIAPIUtil.sendChatGPTRequest(apiKey, prompt);
    }
}
