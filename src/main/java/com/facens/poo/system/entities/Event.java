package com.facens.poo.system.entities;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.facens.poo.system.dto.EventInsertDTO;

@Entity
@Table(name = "TB_EVENT")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_event;

    private String nameEvent;
    private String description;
    private String place;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String emailContact;
    private long amountFreeTickets;
    private long amountFreeTicketsSold;
    private long amountPayedTickets;
    private long amountPayedTicketsSold;
    private double priceTicket;

    public long getAmountFreeTickets() {
        return amountFreeTickets;
    }

    public void setAmountFreeTickets(long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }

    public long getAmountPayedTickets() {
        return amountPayedTickets;
    }

    public void setAmountPayedTickets(long amountPayedTickets) {
        this.amountPayedTickets = amountPayedTickets;
    }

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Event() {

    }

    public Event(EventInsertDTO eventInsertDTO) {
        this.description = eventInsertDTO.getDescription();
        this.nameEvent = eventInsertDTO.getName();
        this.place = eventInsertDTO.getPlace();
        this.startDate = eventInsertDTO.getStartDate();
        this.endDate = eventInsertDTO.getEndDate();
        this.startTime = eventInsertDTO.getStartTime();
        this.endTime = eventInsertDTO.getEndTime();
        this.emailContact = eventInsertDTO.getEmailContact();
        this.amountFreeTickets = eventInsertDTO.getAmountFreeTickets();
        this.amountFreeTicketsSold = eventInsertDTO.getAmountFreeTicketsSold();
        this.amountPayedTickets = eventInsertDTO.getAmountPayedTickets();
        this.amountPayedTicketsSold = eventInsertDTO.getAmountPayedTicketsSold();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id_event;
    }

    public void setId(long id_event) {
        this.id_event = id_event;
    }

    public String getName() {
        return nameEvent;
    }

    public void setName(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }


    
    public long getAmountFreeTicketsSold() {
        return amountFreeTicketsSold;
    }

    public void setAmountFreeTicketsSold(long amountFreeTicketsSold) {
        this.amountFreeTicketsSold = amountFreeTicketsSold;
    }

    public long getAmountPayedTicketsSold() {
        return amountPayedTicketsSold;
    }

    public void setAmountPayedTicketsSold(long amountPayedTicketsSold) {
        this.amountPayedTicketsSold = amountPayedTicketsSold;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id_event ^ (id_event >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (id_event != other.id_event)
            return false;
        return true;
    }

       

}
