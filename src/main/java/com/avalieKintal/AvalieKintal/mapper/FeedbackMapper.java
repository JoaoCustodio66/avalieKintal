package com.avalieKintal.AvalieKintal.mapper;

import com.avalieKintal.AvalieKintal.dto.RequestFeedbackDto;
import com.avalieKintal.AvalieKintal.dto.ResponseFeedbackDto;
import com.avalieKintal.AvalieKintal.entity.Feedback;

public class FeedbackMapper {
    public static Feedback toEntity(RequestFeedbackDto dto) {
        if (dto == null){
            return null;
        }

        Feedback feedback = new Feedback();
        feedback.setFoodRating(dto.foodRating());
        feedback.setServiceRating(dto.serviceRating());
        feedback.setExperienceRating(dto.experienceRating());
        feedback.setComments(dto.comments());
        feedback.setCustomerName(dto.customerName());
        return feedback;
    }

    public static ResponseFeedbackDto toDto(Feedback entity) {
        if (entity == null){
            return null;
        }
        return new ResponseFeedbackDto(
                entity.getId(),
                entity.getFoodRating(),
                entity.getServiceRating(),
                entity.getExperienceRating(),
                entity.getComments(),
                entity.getCustomerName(),
                entity.getSubmittedAt()
        );
    }
}
