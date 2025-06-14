package com.practice_spring_ai.sentiment_analyzer.repository;

import com.practice_spring_ai.sentiment_analyzer.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}