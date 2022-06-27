package engine.screens;

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
    public abstract void paintComponent(Graphics g);
    public void addObject(BaseObject object) {
        objectArray.add(object);
    }
    public Camera getCamera() {return camera;}
    public double windowX() {return camera.x();}
    public double windowY() {return camera.y();}

}
