package com.avalieKintal.AvalieKintal.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "food_rating", nullable = false)
    private Double foodRating;

    @Column(name = "service_rating", nullable = false)
    private Double serviceRating;

    @Column(name = "experience_rating", nullable = false)
    private Double experienceRating;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "submitted_at", nullable = false)
    private LocalDateTime submittedAt;

    public Feedback() {
    }

    public Feedback(int id, Double foodRating, Double serviceRating, Double experienceRating,
                    String comments, String customerName, LocalDateTime submittedAt) {
        this.id = id;
        this.foodRating = foodRating;
        this.serviceRating = serviceRating;
        this.experienceRating = experienceRating;
        this.comments = comments;
        this.customerName = customerName;
        this.submittedAt = submittedAt;
    }


    public int getId() {
        return id;
    }


    public Double getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(Double foodRating) {
        this.foodRating = foodRating;
    }

    public Double getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(Double serviceRating) {
        this.serviceRating = serviceRating;
    }

    public Double getExperienceRating() {
        return experienceRating;
    }

    public void setExperienceRating(Double experienceRating) {
        this.experienceRating = experienceRating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}



