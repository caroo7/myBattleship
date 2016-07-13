package services;

import models.Ship;

import java.awt.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ShipGeneratorImpl implements ShipGenerator {

    private Set<Ship> ships;

    private Set<Point> invalidPositions;

    private Random random = new Random();

    @Override
    public Set<Ship> generateShips() {
        ships = new HashSet<>();
        invalidPositions = new HashSet<>();
        generateShip(4);
        generateShip(3);
        generateShip(3);
        generateShip(2);
        generateShip(2);
        generateShip(2);
        generateShip(1);
        generateShip(1);
        generateShip(1);
        generateShip(1);
        return Collections.unmodifiableSet(ships);
    }


    private void generateShip(int shipLenght) {
        Point point;
        do {
            point = new Point(random.nextInt(10), random.nextInt(10));
        }
        while (invalidPositions.contains(point)||!(random.nextInt(2)==1?checkVertical(point,shipLenght):checkHorizontal(point,shipLenght)));

    }


    private boolean checkVertical(Point startPoint, int shipLength) {
        Point checkPoint;
        Set<Point> points = new HashSet<>();

        for (int i = startPoint.y + 1; i < startPoint.y + shipLength; i++) {
            if (i > 9) return false;
            checkPoint = new Point(startPoint.x, i);
            if (invalidPositions.contains(checkPoint)) return false;
            else points.add(checkPoint);
        }
        points.add(startPoint);
        ships.add(Ship.createShip(points));

        points.add(new Point(startPoint.x,startPoint.y-1));
        points.add(new Point(startPoint.x,startPoint.y+shipLength));

        points.forEach(point -> {
              invalidPositions.add(new Point(point.x-1,point.y));
              invalidPositions.add(point);
              invalidPositions.add(new Point(point.x+1,point.y));
        });



        return true;
    }

    private boolean checkHorizontal(Point startPoint, int shipLength) {
        Point checkPoint;
        Set<Point> points = new HashSet<>();
        for (int i = startPoint.x + 1; i < startPoint.x + shipLength; i++) {
            if (i > 9) return false;

            checkPoint = new Point(i, startPoint.y);
            if (invalidPositions.contains(checkPoint)) return false;
            else points.add(checkPoint);

        }

        points.add(startPoint);
        ships.add(Ship.createShip(points));

        points.add(new Point(startPoint.x-1,startPoint.y));
        points.add(new Point(startPoint.x+shipLength,startPoint.y));

        points.forEach(point -> {
            invalidPositions.add(new Point(point.x,point.y-1));
            invalidPositions.add(point);
            invalidPositions.add(new Point(point.x,point.y+1));
        });


        return true;
    }
}
