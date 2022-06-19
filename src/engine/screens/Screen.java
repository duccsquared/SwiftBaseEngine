package engine.screens;

import engine.Camera;
import engine.Panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public abstract class Screen {
    private String id;
    private Camera camera;
    private boolean isInitialized = false;
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
    public abstract void paintComponent(Graphics g);

}
