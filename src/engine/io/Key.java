package engine.io;

import engine.App;

public class Key {
    public static boolean held(String key) {
        return App.getInstance().held(key);
    }
    public static boolean pressed(String key) {
        return App.getInstance().pressed(key);
    }
}
