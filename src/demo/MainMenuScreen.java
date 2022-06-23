package demo;

import engine.App;
import engine.drawHandlers.RectDraw;
import engine.io.Key;
import engine.objects.BaseObject;
import engine.objects.Sprite;
import engine.screens.BaseScreen;
import engine.screens.Screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MainMenuScreen extends BaseScreen {
    private Sprite x;
    public MainMenuScreen(String id) throws IOException {
        super(id);
        new Sprite(this,100,100,200,200);
        new Sprite(this,new Color(0,0,128),new Color(0,0,168),400,500,550,550);
        x = new Sprite(this,50,128,50,70,168,70,0,0,20,20);
        new Sprite(this,128,128,50,168,168,70,579,579,599,599);
    }

    @Override
    public void tick() {
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
    }
}
