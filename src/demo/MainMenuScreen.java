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
    public MainMenuScreen(String id) {
        super(id);
        Text.newInstance(this,"Swift Base Engine",300,150,40);
        Text.newInstance(this,"Demo Game",300,200,40);
        new PlayGameButton(this,200,300,400,400);
    }

    @Override
    public void tick() {
        super.tick();
    }
}
