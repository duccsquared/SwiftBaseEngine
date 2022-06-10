package engine;

import engine.exceptions.AppNotInstantiatedException;

import javax.swing.*;

public class App extends JFrame {
    private static App instance = null;
    private Panel panel;
    private int width;
    private int height;

    public static App getInstance() {
        if(instance==null) {
            try {
                throw new AppNotInstantiatedException(); // run instantiate() first
            } catch (AppNotInstantiatedException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return instance;
    }
    public static void instantiate(String title, int width, int height, Panel panel) {
        instance = new App(title,width,height,panel);
    }
    private App(String title, int width, int height, Panel panel) {
        super(title);
        this.panel = panel;
        this.add(panel);
        this.width = width;
        this.height = height;
        // JFrame functions
        this.setFocusable(true);
        this.setResizable(false);
        this.setSize(this.width+16,this.height+39);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
