package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyObject {
    private List<Message> messages;
    private String model;
    private int frequency_penalty;
    private int max_tokens;
    private int presence_penalty;
    private Object stop;
    private boolean stream;
    private double temperature;
    private double top_p;
    private boolean logprobs;
    private Object top_logprobs;

    // getter和setter方法
    // ...
}
