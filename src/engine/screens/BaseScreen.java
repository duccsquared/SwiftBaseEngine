package engine.screens;

import engine.App;
import engine.objects.BaseObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public abstract class BaseScreen extends Screen {
    public BaseScreen(String id) {
        super(id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(BaseObject object : objectArray) {
            object.tick();
        }
        this.handleMouseClick();
    }
    private void handleMouseClick() {
        boolean handled = false;
        for(int i = objectArray.size()-1; i > 0; i--) {
            BaseObject object = objectArray.get(i);
            if(object.intersectsAbs(App.getInstance().getMousePosX(),App.getInstance().getMousePosY())) {
                handled = object.tickMouse();
            }
            if(handled) {return;}
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
