package com.restapisample.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Board {

    private int width;
    private int height;
    private Position currentPosition;
    private List<Fighter> fighters;

    public void moveUp() {
        if(currentPosition.getX() != 0) {
            Position newPosition = currentPosition.sum(Position.UP);
            if (getFighterByPosition(newPosition) != null) currentPosition = newPosition;
        }
    }

    public void moveDown() {
        if(currentPosition.getX() != (height - 1))  {
            Position newPosition = currentPosition.sum(Position.DOWN);
            if(getFighterByPosition(newPosition) != null) currentPosition = newPosition;
        }
    }

    public void moveRight() {
        currentPosition = getFirstAvailablePosition(Position.RIGHT);
    }

    public void moveLeft() {
        currentPosition = getFirstAvailablePosition(Position.LEFT);
    }

    public Position getFirstAvailablePosition(Position position) {
        Position newPosition = getPositionInBoard(currentPosition.sum(position));
        while(getFighterByPosition(newPosition) != null) {
            newPosition = newPosition.sum(position);
        }
        return newPosition;
    }

    public Fighter getFighterByPosition(Position position) {
        return fighters.stream()
                .filter(fighter -> fighter.getPosition().equals(position)).findFirst()
                .orElse(null);
    }

    private Position getPositionInBoard(Position position) {
        return new Position(position.getX(), position.getY() % width);
    }
}
