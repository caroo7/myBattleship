package gui;

public class GameRules {

    private static final String NEW_LINE = "\n";

    public static final String rulesMessage =
            "Battleship game\n" +
            "\n" +
            "RULES\n" +
            "Players: \n" +
            "2 players play from same computer or different computers in the same Local Area Network.\n" +
            "\n" +
            "Content: \n" +
            "Each player sees a window/frame with two 10x10 places boards (for himself and for opponent) with ships, a bunch of hit and miss markers and empty places.\n" +
            "\n" +
            "When player tries to shoot he will receive different kind of information:\n" +
            "info that he chose empty place on opponent board (missed) - in this case opponent gets his move and he has to wait.\n" +
            "info about hit the opponent ship (he had chosen place where opponent has his ship). In this case he still can play and his opponent has to wait.\n" +
            "\n" +
            "Goal:\n" +
            "Purpose of the game is to find all opponent's ships before he does. The person who achieves this goal wins and the game ends. \n" +
            "\n";
}
