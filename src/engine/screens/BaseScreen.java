package engine.screens;

import engine.App;
import engine.objects.BaseObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public abstract class BaseScreen extends Screen {
    private ArrayList<SubScreen> subScreenArray = new ArrayList<>();
    public void addSubScreen(SubScreen subScreen) {
        this.subScreenArray.add(subScreen);
    }
    public BaseScreen(String id) {
        super(id);
    }

    @Override
    public void onInit() throws IOException {
        super.onInit();
        for(SubScreen subScreen: subScreenArray) {subScreen.onInit();}
    }

    @Override
    public void onPause() throws IOException {
        super.onPause();
        for(SubScreen subScreen: subScreenArray) {subScreen.onPause();}
    }

    @Override
    public void onUnpause() throws IOException {
        super.onUnpause();
        for(SubScreen subScreen: subScreenArray) {subScreen.onUnpause();}
    }

    @Override
    public void tick() {
        for(SubScreen subScreen: subScreenArray) {subScreen.tick();}
    }

    @Override
    public void secondTick() {
        super.secondTick();
        for(SubScreen subScreen: subScreenArray) {subScreen.secondTick();}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(BaseObject object : objectArray) {
            object.tick();
        }
        for(SubScreen subScreen: subScreenArray) {subScreen.tick();}
        this.handleMouseClick();
    }
    protected boolean handleMouseClick() {
        boolean handled;
        for(int i = subScreenArray.size()-1; i>=0; i--) {
            SubScreen subScreen = subScreenArray.get(i);
            handled = subScreen.handleMouseClick();
            if (handled) {return true;}
        }
        handled = super.handleMouseClick();
        return handled;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(SubScreen subScreen : subScreenArray) {subScreen.paintComponent(g);}

    }
}
