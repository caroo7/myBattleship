package models;

import java.awt.*;
import java.io.Serializable;
import java.util.Set;


public class Board implements Serializable {

    private Cell[][] cells = new Cell[10][10];
    public Set<Ship> ships;

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
