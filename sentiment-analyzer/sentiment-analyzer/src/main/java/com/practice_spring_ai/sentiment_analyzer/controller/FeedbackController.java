package com.practice_spring_ai.sentiment_analyzer.controller;


import com.practice_spring_ai.sentiment_analyzer.entity.Feedback;
import com.practice_spring_ai.sentiment_analyzer.repository.FeedbackRepository;
import com.practice_spring_ai.sentiment_analyzer.service.SentimentAnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:5173/")
public class FeedbackController {

    private final FeedbackRepository feedbackRepository;
    private final SentimentAnalysisService service;

    public FeedbackController(FeedbackRepository feedbackRepository, SentimentAnalysisService service) {
        this.feedbackRepository = feedbackRepository;
        this.service = service;
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @PostMapping
    public Feedback saveFeedback(@RequestBody String content) {
        Feedback feedback = service.analyzeFeedback(content);
        return feedbackRepository.save(feedback);
    }
}