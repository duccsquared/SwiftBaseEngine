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
    public String getId() {return id;}

    protected ArrayList<BaseObject> getObjectArray() {return objectArray;}

    public void setId(String id) {this.id = id;}
    public Screen(String id) {
        this.setId(id);
        this.camera = new Camera();
    }

    public void onInit() throws IOException {};
    public void onPause() throws IOException {};
    public void onUnpause() throws IOException {
        if(!isInitialized) {
            this.isInitialized = true;
            this.onInit();
        }
    };
    public abstract void actionPerformed(ActionEvent e);
    public abstract void tick();
    public void secondTick() {
        camera.updateCameraPos();
    }
    protected boolean handleMouseClick() {
        boolean handled = false;
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
    };
    public void addObject(BaseObject object) {
        objectArray.add(object);
    }
    public void removeObject(BaseObject object) {
        objectArray.remove(object);
    }
    public Camera getCamera() {return camera;}
    public double windowX() {return camera.x();}
    public double windowY() {return camera.y();}

}
