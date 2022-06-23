package engine;

import engine.exceptions.AppNotInstantiatedException;
import engine.exceptions.ExceptionThrower;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class App extends JFrame {
    private static App instance = null;
    private Panel panel;
    private int width;
    private int height;
    private KListener kListener;

    @Override
    public int getWidth() {return width;}
    @Override
    public int getHeight() {
        return height;
    }
    public Panel getPanel() {return panel;}

    public static App getInstance() {
        if(instance==null) {
            ExceptionThrower.throwException(new AppNotInstantiatedException());
        }
        return instance;
    }
    public static boolean isInstantiated() {
        return instance != null;
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
        // listeners
        this.kListener = new KListener();
        this.addKeyListener(kListener);
        // JFrame functions
        this.setFocusable(true);
        this.setResizable(false);
        this.setSize(this.width+16,this.height+39);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformedStart() {

    }
    public void actionPerformedEnd() {
        this.kListener.tick();
    }
    public boolean held(String key) {return this.kListener.held(key);}
    public boolean pressed(String key) {return this.kListener.pressed(key);}

    class KListener implements KeyListener {
        private HashSet<String> heldSet = new HashSet<String>();
        private HashSet<String> pressedSet = new HashSet<String>();
        public void keyTyped(KeyEvent e) {}
        public void keyPressed(KeyEvent e) {
            String key = getKey(e);
            if(!heldSet.contains(key)) {
                pressedSet.add(key);
            }
            heldSet.add(key);
        }
        public void keyReleased(KeyEvent e) {
            heldSet.remove(getKey(e));
        }
        private String getKey(KeyEvent e) {
            return KeyEvent.getKeyText(e.getKeyCode());
        }
        private boolean held(String key) {
            return heldSet.contains(key);
        }
        private boolean pressed(String key) {
            return pressedSet.contains(key);
        }
        public void tick() {
            pressedSet.clear();
        }
    }
}
