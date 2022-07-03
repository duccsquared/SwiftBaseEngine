package demo;

import engine.App;
import engine.ObjectInstanceManager;
import engine.io.Key;
import engine.io.Mouse;
import engine.objects.BaseObject;
import engine.objects.Sprite;
import engine.screens.Screen;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends Sprite {
    public Player(Screen screen, double x1, double y1, double x2, double y2) throws IOException {
        super(screen, "src/demo/res/player.png", x1, y1, x2, y2);
    }

    @Override
    public boolean tickMouse() {
        App.getInstance().getPanel().setCurrentCursor(new Cursor(Cursor.HAND_CURSOR));
        if(Mouse.leftHeld()) {
            this.setAngle(this.getAngle()+1);
            return true;
        }
        return super.tickMouse();
    }

    @Override
    public void tick() {
        super.tick();
        this.setAngle(this.getAngle()+1);
        double xSpeed = 0;
        double ySpeed = 0;
        if(Key.held("W")) {
            ySpeed -= 5;
        }
        if(Key.held("A")) {
            xSpeed -= 5;
        }
        if(Key.held("S")) {
            ySpeed += 5;
        }
        if(Key.held("D")) {
            xSpeed += 5;
        }
        this.moveX(xSpeed);
        this.resolveCollisionsX(Obstacle.class,-xSpeed);
        this.moveY(ySpeed);
        this.resolveCollisionsY(Obstacle.class,-ySpeed);

        if(Key.held("Q")) {
            this.setSize(this.getWidth()-1, this.getHeight()-1);
        }
        if(Key.held("E")) {
            this.setSize(this.getWidth()+1, this.getHeight()+1);
        }
    }
}
