package com.company.spring.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private TheatreStage theatreStage;
    @ManyToOne
    private Performance performance;
    @ManyToOne
    private User user;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Performance getMovie() {
        return performance;
    }

    public void setMovie(Performance performance) {
        this.performance = performance;
    }

    public TheatreStage getCinemaHall() {
        return theatreStage;
    }

    public void setCinemaHall(TheatreStage theatreStage) {
        this.theatreStage = theatreStage;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id
                + ", cinemaHall=" + theatreStage + ", movie=" + performance
                + ", user=" + user + ", showTime=" + showTime + '}';
    }
}
