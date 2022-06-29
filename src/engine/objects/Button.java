package engine.objects;

import engine.App;
import engine.io.Mouse;
import engine.screens.Screen;

import java.awt.*;
import java.io.IOException;

public abstract class Button extends Sprite {
    private Text text;

    public Button(Screen screen, String textStr, Color color, Color borderColor, double x1, double y1, double x2, double y2) throws IOException {
        super(screen, color, borderColor, x1, y1, x2, y2);
        this.text = Text.newInstance(screen,textStr,x1,y1,x2,y2);
    }

    public Button(Screen screen, String textStr, int r, int g, int b, int borderR, int borderG, int borderB, double x1, double y1, double x2, double y2) throws IOException {
        super(screen,  r, g, b, borderR, borderG, borderB, x1, y1, x2, y2);
        this.text = Text.newInstance(screen,textStr,x1,y1,x2,y2);
    }

    public Button(Screen screen, String textStr, String imgPath, double x1, double y1, double x2, double y2) throws IOException {
        super(screen, imgPath, x1, y1, x2, y2);
        this.text = Text.newInstance(screen,textStr,x1,y1,x2,y2);
    }
    public abstract void onClick();

    @Override
    public boolean tickMouse() {
        App.getInstance().getPanel().setCurrentCursor(new Cursor(Cursor.HAND_CURSOR));
        if(Mouse.leftClicked()) {
            this.onClick();
            return true;
        }
        return super.tickMouse();
    }
}