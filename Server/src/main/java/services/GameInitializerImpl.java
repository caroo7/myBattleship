package services;


import model.Board;
import models.Player;
import models.Ship;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class GameInitializerImpl implements GameInitializer {

    private static int playerID;

    @Override
    public Player initGame(Set<Ship> ships) {
        Board board = new Board();
        board.init(ships);
        return null;
    }
}
