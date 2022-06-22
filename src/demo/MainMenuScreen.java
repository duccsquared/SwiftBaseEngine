package demo;

import engine.drawHandlers.RectDraw;
import engine.objects.BaseObject;
import engine.objects.Sprite;
import engine.screens.BaseScreen;
import engine.screens.Screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MainMenuScreen extends BaseScreen {
    public MainMenuScreen(String id) throws IOException {
        super(id);
        this.addObject(new Sprite(this,100,100,200,200));
        this.addObject(new Sprite(this,new Color(0,0,128),new Color(0,0,168),400,500,550,550));
        this.addObject(new Sprite(this,50,128,50,70,168,70,0,0,20,20));
        this.addObject(new Sprite(this,128,128,50,168,168,70,579,579,599,599));
    }

    @Override
    public void tick() {
    }
}
