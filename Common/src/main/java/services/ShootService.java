package services;

import models.BoardElementState;

import java.awt.*;

public interface ShootService {

    BoardElementState shootOn(Point point);
}
