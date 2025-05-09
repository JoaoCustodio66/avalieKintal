package com.avalieKintal.AvalieKintal.repository;

import com.avalieKintal.AvalieKintal.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    @Query(value = """
            SELECT 
                AVG(food_rating) AS average_food_rating, 
                AVG(service_rating) AS average_service_rating, 
                AVG(experience_rating) AS average_experience_rating
            FROM feedbacks
            WHERE submitted_at >= DATE_TRUNC('month', CURRENT_DATE)
              AND submitted_at < DATE_TRUNC('month', CURRENT_DATE) + INTERVAL '1 month'
            """, nativeQuery = true)
    Map<String, Object> findMonthlyAverages();


    @Query(value = """
            SELECT 
                AVG(food_rating) AS average_food_rating, 
                AVG(service_rating) AS average_service_rating, 
                AVG(experience_rating) AS average_experience_rating
            FROM feedbacks
            """, nativeQuery = true)
    Map<String, Object> findTotalAverages();
}
