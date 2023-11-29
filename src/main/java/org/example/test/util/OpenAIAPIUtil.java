package org.example.test.util;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Astar
 * ClassName:OpenAIAPI.java
 * date:2023-03-03 16:49
 * Description:
 */
public class OpenAIAPIUtil {

    public static String sendChatGPTRequest(String apiKey, String prompt) throws Exception {
        //String apiUrl = "https://api.openai.com/v1/chat/completions";
        String apiUrl = "https://test-chi-beige.vercel.app/proxy/api.openai.com/v1/chat/completions";
        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + apiKey);
        connection.setDoOutput(true);

        String requestBody = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try (Scanner scanner = new Scanner(connection.getInputStream(), String.valueOf(StandardCharsets.UTF_8))) {
            return scanner.useDelimiter("\\A").next();
        }
    }

    /*public static void main(String[] args) {
        String apiKey = "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";
        String prompt = "Tell me a joke.";

        try {
            String response = sendChatGPTRequest(apiKey, prompt);
            System.out.println("ChatGPT Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
