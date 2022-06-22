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
        // TEMPORARY
//        g2d.setColor(new Color(100,0,0));
//        g2d.fillRect(0,0, App.getInstance().getWidth()-1,App.getInstance().getHeight()-1);
//        g2d.setColor(new Color(200,0,0));
//        g2d.drawRect(0,0, App.getInstance().getWidth()-1,App.getInstance().getHeight()-1);
        // \TEMPORARY
        for(BaseObject object : objectArray) {
            object.paint(g2d);
        }

    }
}
