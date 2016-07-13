package services;


import models.Player;
import models.Ship;

import java.util.Set;

public interface GameInitializer {
    Player initGame(Set<Ship> ships);
}
