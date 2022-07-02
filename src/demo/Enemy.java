package demo;

import engine.ObjectInstanceManager;
import engine.objects.Sprite;
import engine.screens.Screen;

import java.io.IOException;
import java.util.Random;

public class Enemy extends Sprite {
    double speedX = 0;
    double speedY = 0;
    double speed = 2;
    double nudgeX = 0;
    double nudgeY = 0;
    double targetX = 0;
    double targetY = 0;
    public Enemy(Screen screen, double x, double y) throws IOException {
        super(screen, "src/demo/res/enemy.png", x-20,y-20,x+20,y+20);
        ObjectInstanceManager.getInstance().addInstance(this,Enemy.class);
        speedX = Global.randInt(-3,3);
        speedY = Global.randInt(-3,3);
        targetX = x;
        targetY = y;
    }

    @Override
    public void delete() {
        ObjectInstanceManager.getInstance().removeInstance(this,Enemy.class);
        super.delete();
    }

    @Override
    public void tick() {
        double dist = Global.distance(this.getX(),this.getY(),targetX,targetY);
        if(dist<30 || Global.randRange(0,1)<0.005) {
            speed = Global.randRange(1.5,2.5);
            targetX = Global.randInt(-200,800);
            targetY = Global.randInt(-200,800);
            double[] dirCoor = Global.dirToCoor(Global.coorToDir(this.getX(),this.getY(),targetX,targetY));
            speedX = dirCoor[0] * speed;
            speedY = dirCoor[1] * speed;
        }
        if(Global.randRange(0,1)<0.05) {
            nudgeX = Global.randRange(-0.5,0.5);
            nudgeY = Global.randRange(-0.5,0.5);
        }
        this.moveX(speedX+nudgeX);
        this.resolveCollisionsX(Obstacle.class,-speedX-nudgeX);
        this.resolveCollisionsX(Enemy.class,-speedX-nudgeX);
        this.moveY(speedY+nudgeY);
        this.resolveCollisionsY(Obstacle.class,-speedY-nudgeY);
        this.resolveCollisionsY(Enemy.class,-speedY-nudgeY);
    }
}
