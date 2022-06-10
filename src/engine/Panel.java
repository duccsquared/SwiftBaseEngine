package engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {
    private Timer timer;
    private final int DELAY;
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

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
