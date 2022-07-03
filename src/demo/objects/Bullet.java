package demo.objects;

import demo.Global;
import engine.utils.Mouse;
import engine.objects.Sprite;
import engine.screens.Screen;

public class Bullet extends Sprite {
    private double speed = 5;
    private double startX;
    private double startY;
    private double speedX = 0;
    private double speedY = 0;
    public Bullet(Screen screen, double x, double y) {
        super(screen, "src/demo/res/bullet.png", x - 10, y - 10, x + 10, y + 10);
        this.startX = x;
        this.startY = y;
        this.speed += Global.randRange(-1,1);
        double inaccuracy = Global.randRange(-5,5);
        double[] coords = Global.dirToCoor(Global.coorToDir(x,y, Mouse.relMousePosX(),Mouse.relMousePosY())+inaccuracy);
        speedX = coords[0] * speed;
        speedY = coords[1] * speed;
    }

    @Override
    public void tick() {
        super.tick();
        this.moveX(speedX);
        this.moveY(speedY);
        Enemy intersectingEnemy = (Enemy) this.findIntersecting(Enemy.class);
        if(intersectingEnemy!=null) {
            intersectingEnemy.delete();
            this.delete();
        }
        if(Global.distance(startX,startY,this.getX(),this.getY())>600) {
            this.delete();
        }
    }
}
