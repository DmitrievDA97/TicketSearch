package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportIn;
    private int travelTime;

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }
}
