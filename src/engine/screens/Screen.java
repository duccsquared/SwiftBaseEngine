package engine.screens;

import engine.Panel;

import java.io.IOException;

public abstract class Screen {
    private String id;
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public Screen(String id) {
        this.setId(id);
    }

    public void onInit() throws IOException {};
    public void onPause() throws IOException {};
    public void onUnpause() throws IOException {};

}
