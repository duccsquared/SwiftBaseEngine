package demo;

import engine.Panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class DemoPanel extends Panel {
    public DemoPanel() throws IOException {
        super(Color.darkGray);
    }

    @Override
    public void start() throws IOException {
        this.registerScreen(new MainMenuScreen("mainMenu"));
        this.registerScreen(new GameScreen("game"));
        this.setCurrentScreen("mainMenu");
    }

    @Override
    public void tick(ActionEvent e) {
    }
}
