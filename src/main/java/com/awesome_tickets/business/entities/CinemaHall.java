package com.awesome_tickets.business.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "cinema_hall")
public class CinemaHall implements Serializable {

    private Integer cinemaHallId;
    private String name;
    private Cinema cinema;
    private String seatLayout;

    public CinemaHall() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cinema_hall_id")
    public Integer getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Integer cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    @Column(name = "name", nullable = false, length=10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "seat_layout", nullable = false, length=400)
    public String getSeatLayout() {
        return seatLayout;
    }

    public void setSeatLayout(String seatLayout) {
        this.seatLayout = seatLayout;
    }

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
