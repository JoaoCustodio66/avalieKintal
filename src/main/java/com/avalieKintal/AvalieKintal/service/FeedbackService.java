package com.avalieKintal.AvalieKintal.service;

import com.avalieKintal.AvalieKintal.dto.RequestFeedbackDto;
import com.avalieKintal.AvalieKintal.dto.ResponseApi;
import com.avalieKintal.AvalieKintal.dto.ResponseFeedbackDto;
import com.avalieKintal.AvalieKintal.dto.ResponseRatingDto;
import com.avalieKintal.AvalieKintal.entity.Feedback;
import com.avalieKintal.AvalieKintal.mapper.FeedbackMapper;
import com.avalieKintal.AvalieKintal.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public ResponseApi save(RequestFeedbackDto dto) {
        Feedback feedback = FeedbackMapper.toEntity(dto);
        feedback.setSubmittedAt(LocalDateTime.now());
        ResponseFeedbackDto responseDto = FeedbackMapper.toDto(repository.save(feedback));
        return ResponseApi.success("Success",responseDto);
    }

    public ResponseApi findAll(){
        List<Feedback> feedbacks = repository.findAll();
        List<ResponseFeedbackDto> dto = feedbacks.stream().map(FeedbackMapper::toDto).toList();
        return ResponseApi.success("Success", dto);
    }

    public ResponseApi<ResponseRatingDto> findRating(){
        Map<String, Object> averagesMonth = repository.findMonthlyAverages();
        double foodRatingMonth = averagesMonth.get("average_food_rating") != null ?
                Math.round((Double) averagesMonth.get("average_food_rating") * 10) / 10.0 : 0.0;
        double serviceRatingMonth = averagesMonth.get("average_service_rating") != null ?
                Math.round((Double) averagesMonth.get("average_service_rating") * 10) / 10.0 : 0.0;
        double experienceRatingMonth = averagesMonth.get("average_experience_rating") != null ?
                Math.round((Double) averagesMonth.get("average_experience_rating") * 10) / 10.0 : 0.0;

        Map<String, Object> averagesTotal = repository.findTotalAverages();
        double foodRating = averagesTotal.get("average_food_rating") != null ?
                Math.round((Double) averagesTotal.get("average_food_rating") * 10) / 10.0 : 0.0;
        double serviceRating = averagesTotal.get("average_service_rating") != null ?
                Math.round((Double) averagesTotal.get("average_service_rating") * 10) / 10.0 : 0.0;
        double experienceRating = averagesTotal.get("average_experience_rating") != null ?
                Math.round((Double) averagesTotal.get("average_experience_rating") * 10) / 10.0 : 0.0;

        ResponseRatingDto dto = new ResponseRatingDto(foodRating,
                                    serviceRating, experienceRating,
                                    foodRatingMonth, serviceRatingMonth,
                                                experienceRatingMonth);
        return ResponseApi.success("Success", dto);
    }
}


