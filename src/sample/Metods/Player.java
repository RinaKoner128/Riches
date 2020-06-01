package sample.Metods;

import javafx.event.ActionEvent;

public class Player {
    private String name;
    private Integer count;
    private Integer number;

    public Player(String name, Integer number) {
        this.name = name;
        this.number = number;
        count = 0;
    }

    public boolean pay(Integer number) {
        if (number <= this.number) {
            this.number -= number;
            this.count++;
            return true;
        } else return false;
    }
    public void addNumber(Integer number) {
        this.number += number;
    }
}