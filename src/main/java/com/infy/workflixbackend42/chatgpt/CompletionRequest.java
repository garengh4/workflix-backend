package com.infy.workflixbackend42.chatgpt;

public record CompletionRequest(String model, String prompt, double temperature, int max_tokens) {

    public static CompletionRequest defaultWith(String prompt) {
        // hardcoded model, temperature, token(how long response can be)
        return new CompletionRequest("text-davinci-003", prompt, 0.7, 100);
    }

}