package dev.sidra.music;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicRepository extends MongoRepository<Music, ObjectId> {
    Optional<Music> findMusicByMusicId(String musicId);

    Optional<Music> findById(String musicId);
}

