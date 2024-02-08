package edu.iu.eebridge.ducksservice.controllers;

import edu.iu.eebridge.ducksservice.model.DuckData;
import edu.iu.eebridge.ducksservice.repository.DucksRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


import java.io.IOException;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/ducks")
public class DucksController {
    private DucksRepository ducksRepository;

    public DucksController(DucksRepository ducksRepository) {
        this.ducksRepository = ducksRepository;
    }

    @PostMapping
    public boolean add(@RequestBody DuckData duck) {
        try {
            return ducksRepository.addDuck(duck);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<DuckData> getAllDucks() {
        try {
            return ducksRepository.getAllDucks();
        } catch (IOException e) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public DuckData getDuck(@PathVariable int id) {
        try {
            return ducksRepository.getDuck(id);
        } catch (IOException e) {
            return null;
        }
    }

    @PostMapping("/{id}/image")
    public void updateImage(@PathVariable int id, @RequestParam("file") MultipartFile file) {
        try {
            ducksRepository.updateImage(id, file);
        } catch (IOException e) {
            System.out.println("Update image error.");
        }
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<?> getImage(@PathVariable int id) {
        try {
            byte[] image = ducksRepository.getImage(id);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .contentType(MediaType.IMAGE_PNG)
                    .body(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{id}/audio")
    public void updateAudio(@PathVariable int id, @RequestParam("file") MultipartFile file) {
        try {
            ducksRepository.updateAudio(id, file);
        } catch (IOException e) {
            System.out.println("Update audio error.");
        }
    }

    @GetMapping("/{id}/audio")
    public ResponseEntity<?> getAudio(@PathVariable int id) {
        try {
            byte[] audio = ducksRepository.getAudio(id);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .contentType(MediaType.valueOf("audio/mpeg"))
                    .body(audio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/search")
    public List<DuckData> search(@RequestParam String type) {
        try {
            return ducksRepository.search(type);
        } catch (IOException e) {
            return null;
        }
    }

}