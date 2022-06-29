package engine.objects;

import engine.drawHandlers.DrawHandler;
import engine.drawHandlers.ImageDraw;
import engine.drawHandlers.RectDraw;
import engine.io.Mouse;
import engine.screens.Screen;
import java.awt.*;

import java.io.IOException;

public class Sprite extends BaseObject{
    public Sprite(Screen screen, double x1, double y1, double x2, double y2) throws IOException {
        super(screen, new RectDraw(), x1, y1, x2, y2);
    }
    public Sprite(Screen screen, Color color, Color borderColor, double x1, double y1, double x2, double y2) throws IOException {
        super(screen, new RectDraw(color,borderColor), x1, y1, x2, y2);
    }
    public Sprite(Screen screen,int r, int g, int b, int borderR, int borderG, int borderB, double x1, double y1, double x2, double y2) throws IOException {
        super(screen, new RectDraw(new Color(r,g,b),new Color(borderR,borderG,borderB)), x1, y1, x2, y2);
    }
    public Sprite(Screen screen, String imgPath, double x1, double y1, double x2, double y2) throws IOException {
        super(screen, new ImageDraw(imgPath,x2-x1,y2-y1), x1, y1, x2, y2);
    }

    @Override
    public boolean tickMouse() {
        // TEMPORARY
        if(Mouse.leftClicked()) {
            System.out.println(this.getX()+" "+this.getY());
            return true;
        }
        return super.tickMouse();
    }
}
