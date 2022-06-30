package demo;

import engine.ObjectInstanceManager;
import engine.io.Key;
import engine.io.Mouse;
import engine.objects.BaseObject;
import engine.objects.Sprite;
import engine.screens.BaseScreen;

import java.awt.*;
import java.io.IOException;

public class GameScreen extends BaseScreen {
    private Sprite player;

    public GameScreen(String id) throws IOException {
        super(id);
        new Obstacle(this,100,100,200,200);
        new Obstacle(this,400,500,550,550);
        new Obstacle(this,300,650,900,700);
        new Obstacle(this,-100,200,-50,300);
        new Obstacle(this,600,-200,650,-150);
        new Obstacle(this,600,250,650,300);
        new Obstacle(this,-150,700,50,750);
        new Obstacle(this,300,-400,400,-300);
        player = new Player(this,280,280,320,320);
        System.out.println(((Sprite) player).getClass());
        this.getCamera().attachObject(player);
    }

    @Override
    public void tick() {
        if(Key.pressed("O")) {
            this.getCamera().panTo(-300,-300);
        }
        if(Key.pressed("P")) {
            this.getCamera().panTo(0,0);
        }
        if(Key.pressed("I")) {
            System.out.println(ObjectInstanceManager.getInstance().getArrayList(Obstacle.class).size());
        }
    }
}
