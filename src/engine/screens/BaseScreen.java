package engine.screens;

import engine.App;
import engine.objects.BaseObject;

import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class BaseScreen extends Screen {
    public BaseScreen(String id) {
        super(id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(BaseObject object : objectArray) {
            object.tick();
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(BaseObject object : objectArray) {
            object.paint(g2d);
        }

    }
}
