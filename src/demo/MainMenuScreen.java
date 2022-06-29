package demo;

import engine.App;
import engine.camera.transitions.BezierEaseInOut;
import engine.drawHandlers.RectDraw;
import engine.drawHandlers.TextDraw;
import engine.io.Key;
import engine.io.Mouse;
import engine.objects.BaseObject;
import engine.objects.Sprite;
import engine.objects.Text;
import engine.screens.BaseScreen;
import engine.screens.Screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MainMenuScreen extends BaseScreen {
    private Sprite x;
    public MainMenuScreen(String id) throws IOException {
        super(id);
        Sprite a = new Sprite(this,100,100,200,200);
        Sprite b = new Sprite(this,new Color(0,0,128),new Color(0,0,168),400,500,550,550);
        x = new Sprite(this,"src/demo/fireball.png",280,280,320,320);
        Sprite c = new Sprite(this,128,128,50,168,168,70,579,579,599,599);
        Text.newInstance(this,"-------------------||T||-------------------",300,20,30,0,1);
        Text.newInstance(this,"Welcome!",300,400,"Power Green",Font.PLAIN,20,0,255,0,0,0,false);
        Text.newInstance(this,"-------------------||T||-------------------",20,550,580,590);
        Text.newInstance(this,"This is the main menu",200,420,400,440,"Power Green",Font.PLAIN,0,255,0,false);
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
