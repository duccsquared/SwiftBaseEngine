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
    public Player(Screen screen, double x1, double y1, double x2, double y2) {
        super(screen, "src/demo/res/player.png", x1, y1, x2, y2);
    }

    @Override
    public boolean tickMouse() {
        Mouse.setCursorToHandCursor();
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
        if(Key.held(Key.W)) {
            ySpeed -= 5;
        }
        if(Key.held(Key.A)) {
            xSpeed -= 5;
        }
        if(Key.held(Key.S)) {
            ySpeed += 5;
        }
        if(Key.held(Key.D)) {
            xSpeed += 5;
        }
        this.moveX(xSpeed);
        this.resolveCollisionsX(Obstacle.class,-xSpeed);
        this.moveY(ySpeed);
        this.resolveCollisionsY(Obstacle.class,-ySpeed);

        if(Key.held(Key.Q)) {
            this.setSize(this.getWidth()-1, this.getHeight()-1);
        }
        if(Key.held(Key.E)) {
            this.setSize(this.getWidth()+1, this.getHeight()+1);
        }
        if(Key.held(Key.SPACE)) {
            this.setFixChildrenAngleToParent(false);
            this.setAngle(this.getAngle()+1);
            this.setFixChildrenAngleToParent(true);
        }
        if(Key.held(Key.SHIFT)) {
            this.setFixChildrenAngleToParent(false);
            this.setAngle(this.getAngle()+1);
            this.setFixChildrenAngleToParent(true);
        }
    }
}
