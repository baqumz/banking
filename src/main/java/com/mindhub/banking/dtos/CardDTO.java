package com.mindhub.banking.dtos;

import com.mindhub.banking.models.Card;
import com.mindhub.banking.models.CardColor;
import com.mindhub.banking.models.CardType;

import java.time.LocalDateTime;

public class CardDTO {

    private CardType type;
    private CardColor color;
    private LocalDateTime thruDate;
    private LocalDateTime fromDate;
    private String cardholder;
    private Integer cvv;

    public CardDTO() {}

    public CardDTO(Card c) {
        this.type = c.getType();
        this.color = c.getColor();
        this.thruDate = c.getThruDate();
        this.fromDate = c.getFromDate();
        this.cardholder = c.getCardholder();
        this.cvv = c.getCvv();
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public LocalDateTime getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDateTime thruDate) {
        this.thruDate = thruDate;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

}
