package com.avalieKintal.AvalieKintal.controller;

import com.avalieKintal.AvalieKintal.dto.RequestFeedbackDto;
import com.avalieKintal.AvalieKintal.dto.ResponseApi;
import com.avalieKintal.AvalieKintal.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<ResponseApi> create(@RequestBody RequestFeedbackDto dto){
        ResponseApi response = feedbackService.save(dto);
        return ResponseEntity.status(response.status()).body(response);
    }
}
