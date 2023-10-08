package dev.sidra.music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/music")
public class MusicController {

    @Autowired
    private MusicService service;

    @GetMapping
    public ResponseEntity<List<Music>> getMusic() {
        List<Music> musicList = service.findAllMusic();
        return new ResponseEntity<>(musicList, HttpStatus.OK);
    }

    @GetMapping("/{musicId}")
    public ResponseEntity<Music> getSingleMusic(@PathVariable String musicId) {
        Optional<Music> music = service.findMusicById(musicId);
        return music.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

