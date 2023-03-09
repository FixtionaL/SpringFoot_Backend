package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferTrackerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TransferRepository transferRepository;

    // Get all players
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Create a new player
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    // Get a single player by ID
    public Player getPlayerById(Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow();
    }

    // Update a player
    public Player updatePlayer(Long playerId, Player playerDetails) {
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
    public void deletePlayer(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow();

        playerRepository.delete(player);
    }

    // Get all transfers
    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }

    // Create a new transfer
    public Transfer createTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    // Get a single transfer by ID
    public Transfer getTransferById(Long transferId) {
        return transferRepository.findById(transferId)
                .orElseThrow();
    }

    // Update a transfer
    public Transfer updateTransfer(Long transferId, Transfer transferDetails) {
        Transfer transfer = transferRepository.findById(transferId)
                .orElseThrow();

        transfer.setPlayer(transferDetails.getPlayer());
        transfer.setBuyingClub(transferDetails.getBuyingClub());
        transfer.setTransferDate(transferDetails.getTransferDate());
        transfer.setTransferAmount(transferDetails.getTransferAmount());

        Transfer updatedTransfer = transferRepository.save(transfer);
        return updatedTransfer;
    }

    // Delete a transfer
    public void deleteTransfer(Long transferId) {
        Transfer transfer = transferRepository.findById(transferId)
                .orElseThrow();

        transferRepository.delete(transfer);
    }
}

