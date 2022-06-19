package demo;

import engine.Panel;

import java.awt.*;
import java.io.IOException;

public class DemoPanel extends Panel {
    public DemoPanel() throws IOException {
        super(Color.darkGray);
        this.registerScreen(new MainMenuScreen("mainMenu"));
        this.setCurrentScreen("mainMenu");
    }
}
