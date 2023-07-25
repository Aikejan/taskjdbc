package org.example.model;

import java.time.LocalDateTime;

public class ShowTime {
    public String foundById;
    private Long id;
    private  Long movieid;
    private  Long teatreId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ShowTime() {
    }

    public ShowTime( Long movieid, Long teatreId, LocalDateTime startTime, LocalDateTime endTime) {
        this.movieid = movieid;
        this.teatreId = teatreId;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieid() {
        return movieid;
    }

    public void setMovieid(Long movieid) {
        this.movieid = movieid;
    }

    public Long getTeatre() {
        return teatreId;
    }

    public void setTeatre(Long teatre) {
        this.teatreId = teatre;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "id=" + id +
                "\n movieid: " + movieid +
                "\n teatreId: " + teatreId +
                "\n startTime: " + startTime +
                " endTime: " + endTime ;
    }
}
