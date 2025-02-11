package com.voting.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voting.Entity.Appeal;
import com.voting.Repository.AppealRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appeals")
public class AppealController {
    private final AppealRepository appealRepository;

    public AppealController(AppealRepository appealRepository) {
        this.appealRepository = appealRepository;
    }

    // Get all appeals
    @GetMapping
    public List<Appeal> getAllAppeals() {
        return appealRepository.findAll();
    }

    // Get appeal by ID
    @GetMapping("/{id}")
    public ResponseEntity<Appeal> getAppealById(@PathVariable Integer id) {
        Optional<Appeal> appeal = appealRepository.findById(id);
        return appeal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add new appeal
    @PostMapping
    public Appeal addAppeal(@RequestBody Appeal appeal) {
        return appealRepository.save(appeal);
    }

    // Delete an appeal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppeal(@PathVariable Integer id) {
        if (appealRepository.existsById(id)) {
            appealRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
