package demo;

import engine.ObjectInstanceManager;
import engine.objects.Sprite;
import engine.screens.Screen;


public class Obstacle extends Sprite {
    public Obstacle(Screen screen, double x1, double y1, double x2, double y2) {
        super(screen, 100, 100, 150, 255, 255, 255, x1, y1, x2, y2);
        ObjectInstanceManager.getInstance().addInstance(this,Obstacle.class);
        this.setDraggable(true);
    }


    @Override
    public void delete() {
        ObjectInstanceManager.getInstance().removeInstance(this,Obstacle.class);
        super.delete();
    }
}
