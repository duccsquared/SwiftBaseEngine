package engine.objects;

import com.sun.javaws.exceptions.InvalidArgumentException;
import engine.exceptions.ExceptionThrower;
import engine.utils.Mouse;
import engine.screens.Screen;

public class Tooltip extends Sprite {
    public static final int UP = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int DOWN = 3;
    private Text text;
    public Tooltip(Screen screen, int r, int g, int b, int borderR, int borderG, int borderB, double x1, double y1, double x2, double y2) {
        super(screen, r, g, b, borderR, borderG, borderB, x1, y1, x2, y2);
    }
    public static Tooltip newInstance(Screen screen, BaseObject parent, String tooltipStr) {
        return newInstance(screen,parent,tooltipStr,Tooltip.UP,20,80,80,80,200,200,200);
    }
    public static Tooltip newInstance(Screen screen, BaseObject parent, String tooltipStr, int orientation, int fontSize, int r, int g, int b, int borderR, int borderG, int borderB) {
        Text text = Text.newInstance(screen,tooltipStr,parent.getX(),parent.getY(),fontSize);
        double borderMarginFrac = 0.2;
        double borderMarginWidth = text.getWidth() * borderMarginFrac;
        double borderMarginHeight = text.getHeight() * borderMarginFrac;
        double diffX = parent.getWidth()/2 + (text.getWidth())/2 + borderMarginWidth;
        double diffY = parent.getHeight()/2 + (text.getHeight())/2 + borderMarginHeight;
        double diffMargin = 0.2 * Math.min(parent.getWidth(),parent.getHeight());

        switch (orientation) {
            case Tooltip.UP:
                text.setY(parent.getY()-diffY-diffMargin);
                break;
            case Tooltip.DOWN:
                text.setY(parent.getY()+diffY+diffMargin);
                break;
            case Tooltip.LEFT:
                text.setX(parent.getX()-diffX-diffMargin);
                break;
            case Tooltip.RIGHT:
                text.setX(parent.getX()+diffX+diffMargin);
                break;
            default:
                ExceptionThrower.throwException(new InvalidArgumentException(new String[]{"invalid orientation for tooltip"}));
        }
        Tooltip tooltip = new Tooltip(screen,r,g,b,borderR,borderB,borderG,
                text.getX1()-borderMarginWidth,text.getY1()-borderMarginHeight,
                text.getX2()+borderMarginWidth,text.getY2()+borderMarginHeight);
        tooltip.addChild(text);
        tooltip.text = text;
        //parent.addChild(tooltip);
        tooltip.setParent(parent);
        return tooltip;
    }

    @Override
    public void tick() {
        super.tick();
        if(parent().intersectsAbs(Mouse.mousePosX(),Mouse.mousePosY())) {
            this.setVisible(true);
            text.setVisible(true);
        }
        else {
            this.setVisible(false);
            text.setVisible(false);
        }
    }
}
