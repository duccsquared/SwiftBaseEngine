package demo;

import engine.io.Key;
import engine.io.Mouse;
import engine.objects.Sprite;
import engine.objects.Text;
import engine.screens.BaseScreen;

import java.awt.*;
import java.io.IOException;

public class GameScreen extends BaseScreen {
    private Sprite x;

    public GameScreen(String id) throws IOException {
        super(id);
        Sprite a = new Sprite(this,100,100,200,200);
        Sprite b = new Sprite(this,new Color(0,0,128),new Color(0,0,168),400,500,550,550);
        x = new Sprite(this,"src/demo/fireball.png",280,280,320,320);
        Sprite c = new Sprite(this,128,128,50,168,168,70,579,579,599,599);
        this.getCamera().attachObject(x);
        c.setFixedPos(true);
    }

    @Override
    public void tick() {
        if(Mouse.leftClicked()) {
            x.setAngle(0);
        }
        x.setAngle(x.getAngle()+1);
        if(Key.held("W")) {
            x.moveY(-5);
        }
        if(Key.held("A")) {
            x.moveX(-5);
        }
        if(Key.held("S")) {
            x.moveY(5);
        }
        if(Key.held("D")) {
            x.moveX(5);
        }
        if(Key.pressed("O")) {
            this.getCamera().panTo(-300,-300);
        }
        if(Key.pressed("P")) {
            this.getCamera().panTo(0,0);
        }
        if(Key.held("Q")) {
            x.setSize(x.getWidth()-1,x.getHeight()-1);
        }
        if(Key.held("E")) {
            x.setSize(x.getWidth()+1,x.getHeight()+1);
        }
    }
}