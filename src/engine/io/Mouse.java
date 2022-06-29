package engine.io;

import engine.App;

public class Mouse {
    public static boolean clicked(int button) {return App.getInstance().clicked(button);}
    public static boolean held(int button) {return App.getInstance().held(button);}
    public static boolean doubleClicked(int button) {return App.getInstance().doubleClicked(button);}
    public static boolean leftClicked() {return Mouse.clicked(1);}
    public static boolean leftHeld() {return Mouse.held(1);}
    public static boolean leftDoubleClicked() {return Mouse.doubleClicked(1);}
    public static boolean middleClicked() {return Mouse.clicked(2);}
    public static boolean middleHeld() {return Mouse.held(2);}
    public static boolean middleDoubleClicked() {return Mouse.doubleClicked(2);}
    public static boolean rightClicked() {return Mouse.clicked(3);}
    public static boolean rightHeld() {return Mouse.held(3);}
    public static boolean rightDoubleClicked() {return Mouse.doubleClicked(3);}
    public static double mousePosX() {return App.getInstance().getMousePosX();}
    public static double mousePosY() {return App.getInstance().getMousePosY();}
}
