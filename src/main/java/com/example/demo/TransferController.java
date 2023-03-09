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
public class TransferController {
	
	@Autowired
	private TransferRepository transferRepository;
	
	// Get all transfers
    @GetMapping("/transfers")
    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }
    
    // Create a new transfer
    @PostMapping("/transfers")
    public Transfer createTransfer(@RequestBody Transfer transfer) {
        return transferRepository.save(transfer);
    }
    
    // Get a single transfer by ID
    @GetMapping("/transfers/{id}")
    public Transfer getTransferById(@PathVariable(value = "id") Long transferId) {
        return transferRepository.findById(transferId)
                .orElseThrow();
    }
    
    // Update a transfer
    @PutMapping("/transfers/{id}")
    public Transfer updateTransfer(@PathVariable(value = "id") Long transferId,
                             @RequestBody Transfer transferDetails) {
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
    @DeleteMapping("/transfers/{id}")
    public ResponseEntity<?> deleteTransfer(@PathVariable(value = "id") Long transferId) {
        Transfer transfer = transferRepository.findById(transferId)
                .orElseThrow();

        transferRepository.delete(transfer);

        return ResponseEntity.ok().build();
    }
}