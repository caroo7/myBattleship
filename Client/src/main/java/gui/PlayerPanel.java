package gui;

import models.*;
import org.springframework.beans.factory.annotation.Autowired;
import services.GameInitializer;
import services.ShipGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class PlayerPanel {

    @Autowired
    ShipGenerator shipGenerator;

    @Autowired
    GameInitializer gameInitializer;

    @Autowired
    BoardPanel boardPanel;

    private Set<Ship> ships;

    private Player playerID;

    public JPanel createPlayerPanel(BoardType boardType) {
        JPanel playerPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel(boardType.toString() + " boardPanel");
        title.setFont(new Font("Dialog", Font.BOLD, 15));

        playerPanel.add(title, BorderLayout.NORTH);
        playerPanel.add(boardPanel, BorderLayout.CENTER);

        if (boardType.equals(BoardType.Yours)) playerPanel.add(userButtonsPanel(), BorderLayout.SOUTH);
        else playerPanel.add(rivalButtonsPanel(), BorderLayout.SOUTH);

        return playerPanel;
    }


    private JPanel userButtonsPanel() {
        JPanel buttons = new JPanel();
        JButton generateShipsButton = new JButton("Generate ships");
        JButton startButton = new JButton("Start game");
        startButton.setEnabled(false);

        //TODO cut out this part of game logic
        startButton.addActionListener(e -> {
            gameInitializer.initGame(ships);
        });
        generateShipsButton.addActionListener(e -> {
            boardPanel.setEmptyBoard();
            startButton.setEnabled(true);
            try {
                ships = shipGenerator.generateShips();
                ships.stream().forEach(ship -> boardPanel.setUserBoardState(ship.getCoordinates(), BoardElementState.SHIP));
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Cannot establish connection with server", "Connection error", JOptionPane.ERROR_MESSAGE);
            }
        });

        startButton.addActionListener(actionEvent -> generateShipsButton.setEnabled(false));
        JButton rulesButton = new JButton("Rules");

        rulesButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, GameRules.rulesMessage, "Game rules", JOptionPane.INFORMATION_MESSAGE);
        });

        buttons.add(generateShipsButton);
        buttons.add(startButton);
        buttons.add(rulesButton);
        return buttons;
    }

    private JPanel rivalButtonsPanel() {
        JPanel labelPanel = new JPanel();
        JLabel turnLabel = new JLabel("Your turn");
        turnLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        labelPanel.add(turnLabel);
        return labelPanel;
    }
}
