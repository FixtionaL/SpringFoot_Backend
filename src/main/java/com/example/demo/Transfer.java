package com.example.demo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "buying_club")
    private String buyingClub;

    @Column(name = "transfer_date")
    private Date transferDate;

    @Column(name = "transfer_amount")
    private double transferAmount;

    public Transfer() {
    }

    

    public Transfer(Long id, Player player, String buyingClub, Date transferDate, double transferAmount) {
		super();
		this.id = id;
		this.player = player;
		this.buyingClub = buyingClub;
		this.transferDate = transferDate;
		this.transferAmount = transferAmount;
	}



	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getBuyingClub() {
        return buyingClub;
    }

    public void setBuyingClub(String buyingClub) {
        this.buyingClub = buyingClub;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }
}
