package ch.zli.m223.model;

import java.time.LocalDateTime;

public class Booking {
    private Long id;

    private LocalDateTime data;

    private boolean isHalfDay;

    // private Drink drink;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isIsHalfDay() {
        return this.isHalfDay;
    }

    public void setIsHalfDay(boolean isHalfDay) {
        this.isHalfDay = isHalfDay;
    }

    /*
     * public private getDrink() {
     * return this.Drink;
     * }
     * 
     * public void setDrink(private Drink) {
     * this.Drink = Drink;
     * }
     */
}
