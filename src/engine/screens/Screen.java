package engine.screens;

import engine.App;
import engine.camera.Camera;
import engine.objects.BaseObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Screen {
    private String id;
    private Camera camera;
    private boolean isInitialized = false;
    protected ArrayList<BaseObject> objectArray = new ArrayList<BaseObject>();
    private ArrayList<SubScreen> subScreenArray = new ArrayList<>();
    private Screen parentScreen = null;

    public String getId() {return id;}
    protected ArrayList<BaseObject> getObjectArray() {return objectArray;}
    public void addSubScreen(SubScreen subScreen) {
        this.subScreenArray.add(subScreen);
    }
    public void setId(String id) {this.id = id;}
    public Screen(String id) {
        this.setId(id);
        this.camera = new Camera();
    }
    public Screen(String id, Screen parentScreen) {
        this.setId(id);
        this.parentScreen = parentScreen;
        this.camera = new Camera();
    }

    public void onInit() throws IOException {
        for(SubScreen subScreen: subScreenArray) {subScreen.onInit();}
    };
    public void onPause() throws IOException {
        for(SubScreen subScreen: subScreenArray) {subScreen.onPause();}
    };
    public void onUnpause() throws IOException {
        if(!isInitialized) {
            this.isInitialized = true;
            this.onInit();
        }
        for(SubScreen subScreen: subScreenArray) {subScreen.onUnpause();}
    };
    public void actionPerformed(ActionEvent e) {
        for(BaseObject object : objectArray) {
            object.tick();
        }
        for(SubScreen subScreen: subScreenArray) {subScreen.tick();}
    };
    public void tick() {
        for(SubScreen subScreen: subScreenArray) {subScreen.tick();}
    };
    public void secondTick() {
        camera.updateCameraPos();
        for(SubScreen subScreen: subScreenArray) {subScreen.secondTick();}
    }
    protected boolean handleMouseClick() {
        boolean handled = false;
        for(int i = subScreenArray.size()-1; i>=0; i--) {
            SubScreen subScreen = subScreenArray.get(i);
            handled = subScreen.handleMouseClick();
            if (handled) {return true;}
        }
        for(int i = objectArray.size()-1; i >= 0; i--) {
            BaseObject object = objectArray.get(i);
            if(object.intersectsAbs(App.getInstance().getMousePosX(),App.getInstance().getMousePosY())) {
                handled = object.tickMouse();
            }
            if(handled) {return true;}
        }
        return false;
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(BaseObject object : objectArray) {
            object.paint(g2d);
        }
        for(SubScreen subScreen : subScreenArray) {subScreen.paintComponent(g);}
    };
    public void addObject(BaseObject object) {
        objectArray.add(object);
    }
    public void removeObject(BaseObject object) {
        objectArray.remove(object);
    }
    public Screen parent() {
        return this.parentScreen;
    }
    public Screen root() {
        if(this.parentScreen==null) {return this;}
        else {return parentScreen.root();}
    }
    public Camera getCamera() {return camera;}
    public double windowX() {return camera.x();}
    public double windowY() {return camera.y();}

}
