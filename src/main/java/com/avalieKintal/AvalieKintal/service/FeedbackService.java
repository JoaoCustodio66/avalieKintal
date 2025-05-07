package com.avalieKintal.AvalieKintal.service;

import com.avalieKintal.AvalieKintal.dto.RequestFeedbackDto;
import com.avalieKintal.AvalieKintal.dto.ResponseApi;
import com.avalieKintal.AvalieKintal.dto.ResponseFeedbackDto;
import com.avalieKintal.AvalieKintal.entity.Feedback;
import com.avalieKintal.AvalieKintal.mapper.FeedbackMapper;
import com.avalieKintal.AvalieKintal.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}


