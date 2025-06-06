package org.example.radio.Music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/Api/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping("")
    public String welcome() {
        return "-Daiv Reyes, Gesler Herrera, Hagzaelt Ortega. All rights reserved";
    }

    @GetMapping("/summary")
    public Map<String, Object> getSummary() {
        return musicService.getMusicSummary();
    }
}
