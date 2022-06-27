package engine.io;

import engine.App;

public class Key {
    public static boolean held(String key) {
        return App.getInstance().held(key);
    }
    public static boolean pressed(String key) {
        return App.getInstance().pressed(key);
    }
    public static boolean bothHeld(String key1, String key2) {
        return Key.held(key1) && Key.held(key2);
    }
    public static boolean bothPressed(String key1, String key2) {
        return Key.pressed(key1) && Key.pressed(key2);
    }
}
