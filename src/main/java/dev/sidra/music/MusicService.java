package dev.sidra.music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private MusicRepository repository;

    public List<Music> findAllMusic() {
        return repository.findAll();
    }

    public Optional<Music> findMusicById(String musicId) {
        return repository.findById(musicId);
    }
}
