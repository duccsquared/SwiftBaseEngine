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
    public MainMenuScreen(String id) throws IOException {
        super(id);
        Text.newInstance(this,"-------------------||T||-------------------",300,20,30,0,1);
        Text.newInstance(this,"Welcome!",300,400,"Power Green",Font.PLAIN,20,0,255,0,0,0,false);
        Text.newInstance(this,"-------------------||T||-------------------",20,550,580,590);
        Text.newInstance(this,"This is the main menu",200,420,400,440,"Power Green",Font.PLAIN,0,255,0,false);
        new PlayGameButton(this,240,450,360,510);
    }

    @Override
    public void tick() {
    }
}
