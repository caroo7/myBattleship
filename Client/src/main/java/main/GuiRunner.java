package main;
import gui.BattleshipMainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;

public class GuiRunner {

        @Autowired
        BattleshipMainFrame battleshipMainFrame;

        @PostConstruct
        public void init() {
            EventQueue.invokeLater(()-> battleshipMainFrame.show());
        }

}
