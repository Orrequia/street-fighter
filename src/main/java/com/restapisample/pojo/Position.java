package com.restapisample.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {
    private int x;
    private int y;

    public static final Position UP = new Position(0, -1);
    public static final Position DOWN = new Position(0, 1);
    public static final Position LEFT = new Position(-1, 0);
    public static final Position RIGHT = new Position(1, 0);

    public Position sum(Position other) {
        return new Position(getX() + other.getX(), getY() + other.getY());
    }
}
