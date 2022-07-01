package demo;

import engine.objects.Sprite;
import engine.screens.Screen;

import java.io.IOException;
import java.util.Random;

public class Enemy extends Sprite {
    Random random = new Random();
    double speedX = 0;
    double speedY = 0;
    public Enemy(Screen screen, double x, double y) throws IOException {
        super(screen, "src/demo/res/enemy.png", x-20,y-20,x+20,y+20);
        speedX = random.nextDouble() * 6 - 3;
        speedY = random.nextDouble() * 6 - 3;
    }

    @Override
    public void tick() {
        if(random.nextDouble()<0.05) {
            speedX = random.nextDouble() * 6 - 3;
            speedY = random.nextDouble() * 6 - 3;
        }
        this.moveX(speedX);
        this.resolveCollisionsX(Obstacle.class,-speedY);
        this.moveY(speedY);
        this.resolveCollisionsY(Obstacle.class,-speedY);
    }
}
