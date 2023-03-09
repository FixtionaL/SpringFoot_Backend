package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class TransferTrackerController {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    
    // Get all players
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    
    // Create a new player
    @PostMapping("/players")
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }
    
    // Get a single player by ID
    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable(value = "id") Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow();
    }
    
    // Update a player
    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable(value = "id") Long playerId,
                           @RequestBody Player playerDetails) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow();

        player.setName(playerDetails.getName());
        player.setAge(playerDetails.getAge());
        player.setPosition(playerDetails.getPosition());
        player.setPreviousClub(playerDetails.getPreviousClub());

        Player updatedPlayer = playerRepository.save(player);
        return updatedPlayer;
    }
    
    // Delete a player
    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable(value = "id") Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow();

        playerRepository.delete(player);

        return "Deleted";
    }
}
