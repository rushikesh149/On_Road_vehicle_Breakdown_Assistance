package com.ora.dao;

import java.util.List;

import com.ora.entity.Feedback;

public interface FeedbackDAO {
 public boolean addFeedback(Feedback feedback);
 public List<Feedback> viewFeedback(int mecId);
 public List<Feedback> viewFeedback();
 public boolean ratings(int mecId);

}
