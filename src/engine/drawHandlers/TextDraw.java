package engine.drawHandlers;

import engine.objects.BaseObject;
import engine.objects.Text;

import java.awt.*;

public class TextDraw extends DrawHandler {
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
