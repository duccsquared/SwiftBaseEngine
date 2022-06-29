package engine.drawHandlers;

import engine.objects.BaseObject;
import engine.objects.Text;

import java.awt.*;

public class TextDraw extends DrawHandler {
    public static final int TOP = -1; public static final int BOTTOM = 1;
    public static final int CENTER = 0;
    public static final int LEFT = -1; public static final int RIGHT = 1;
    private int hAlign = TextDraw.CENTER;
    private int vAlign = TextDraw.CENTER;
    public TextDraw() {
        hAlign = TextDraw.CENTER;
        vAlign = TextDraw.CENTER;
    }
    public TextDraw(int hAlign, int vAlign) {
        this.hAlign = hAlign;
        this.vAlign = vAlign;
    }
    @Override
    public void paint(Graphics2D g2d, BaseObject object) {
        Text text = (Text) object;
        g2d.setColor(text.getColor());
        g2d.setFont(text.getFont());
        double x = text.getAbsX1();
        double y = text.getAbsY1() + text.getHeight(); // Y2
        g2d.drawString(text.getString(),(int) x,(int) y);
    }
}
