package model;

import models.BoardElementState;
import models.Ship;

import java.awt.*;
import java.util.Set;


public class Board {


    private Cell[][] cells = new Cell[10][10];
    public Set<Ship> ships;

    // TODO setter or constructor???? How to set dependency on Set of Ships in board

    public void init(Set<Ship> ships) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new Cell();
            }
        }
        for (Ship ship : ships) {
            Set<Point> coordinates = ship.getCoordinates();
            for (Point point : coordinates) {
                cells[point.x][point.y].putShip(ship);
            }
        }

    }

    public BoardElementState shootOnCell(Point point) {
        return cells[point.x][point.y].shoot(point);
    }

    public void killCell(Point point) {
        cells[point.x][point.y].state = BoardElementState.SINKED;
    }


}
