package dev.sidra.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String reviewBody, String musicId) {
        Reviews review = repository.insert(new Reviews(reviewBody, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(Music.class)
                .matching(Criteria.where("musicId").is(musicId))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }
}
