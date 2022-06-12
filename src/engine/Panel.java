package engine;

import engine.screens.BaseScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract class Panel extends JPanel implements ActionListener {
    private Timer timer;
    private final int DELAY;
    private BaseScreen currentScreen;
    private HashMap<String, BaseScreen> screenHash;
    public Panel(Color color) {
        setBackground(color);
        this.DELAY = 10; // 100 fps
        timer = new Timer(DELAY, this);
        timer.start();
    }
    public Panel(Color color, int delay) {
        setBackground(color);
        this.DELAY = delay;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    public void registerScreen(BaseScreen screen) {screenHash.put(screen.getId(),screen);}
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
