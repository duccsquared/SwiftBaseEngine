package demo.skeleton;

import engine.skeleton.Panel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class DemoPanel extends Panel {
    public DemoPanel(){
        super(Color.darkGray);
    }

    @Override
    public void start() {
        this.registerScreen(new MainMenuScreen("mainMenu"));
        this.registerScreen(new GameScreen("game"));
        this.setCurrentScreen("mainMenu");
    }

    @Override
    public void tick(ActionEvent e) {
    }
}
