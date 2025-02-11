package com.voting.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voting.Entity.Voting;
import com.voting.Repository.VotingRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/voting")
public class VotingController {
    private final VotingRepository votingRepository;

    public VotingController(VotingRepository votingRepository) {
        this.votingRepository = votingRepository;
    }

    // Get all candidates
    @GetMapping
    public List<Voting> getAllCandidates() {
        return votingRepository.findAll();
    }

    // Get candidate by ID
    @GetMapping("/{id}")
    public ResponseEntity<Voting> getCandidateById(@PathVariable Integer id) {
        Optional<Voting> candidate = votingRepository.findById(id);
        return candidate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add new candidate
    @PostMapping
    public Voting addCandidate(@RequestBody Voting voting) {
        return votingRepository.save(voting);
    }

    // Update candidate
    @PutMapping("/{id}")
    public ResponseEntity<Voting> updateCandidate(@PathVariable Integer id, @RequestBody Voting updatedVoting) {
        return votingRepository.findById(id).map(voting -> {
            voting.setName(updatedVoting.getName());
            voting.setParty(updatedVoting.getParty());
            return ResponseEntity.ok(votingRepository.save(voting));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a candidate
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Integer id) {
        if (votingRepository.existsById(id)) {
            votingRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
