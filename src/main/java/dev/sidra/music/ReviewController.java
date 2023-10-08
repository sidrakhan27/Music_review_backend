package dev.sidra.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/music-reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping()
    public ResponseEntity<Reviews> createMusicReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(service.createReview(payload.get("reviewBody"), payload.get("musicId")), HttpStatus.OK);
    }
}
