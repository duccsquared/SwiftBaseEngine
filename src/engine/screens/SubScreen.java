package engine.screens;

import engine.AABB;
import engine.drawHandlers.DrawHandler;
import engine.drawHandlers.EmptyDraw;
import engine.io.Mouse;
import engine.objects.BaseObject;
import engine.objects.ConcreteSprite;
import engine.objects.Sprite;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public abstract class SubScreen extends Screen {
    private Sprite bgSprite;
    public SubScreen(String id, BaseScreen screen, double x1, double y1, double x2, double y2) {
        super(id,screen); bgSprite = new ConcreteSprite(screen,new EmptyDraw(),x1,y1,x2,y2);
        bgSprite.setFixedPos(true);
    }
    public SubScreen(String id, BaseScreen screen, Color color, Color borderColor, double x1, double y1, double x2, double y2) {
        super(id,screen); bgSprite = new ConcreteSprite(screen,color,borderColor,x1,y1,x2,y2);
        bgSprite.setFixedPos(true);
    }
    public SubScreen(String id, BaseScreen screen, int r, int g, int b, int borderR, int borderG, int borderB, double x1, double y1, double x2, double y2)  {
        super(id,screen); bgSprite = new ConcreteSprite(screen,r,g,b,borderR,borderG,borderB,x1,y1,x2,y2);
        bgSprite.setFixedPos(true);
    }
    public SubScreen(String id, BaseScreen screen, String imgPath, double x1, double y1, double x2, double y2)  {
        super(id,screen); bgSprite = new ConcreteSprite(screen,imgPath,x1,y1,x2,y2);
        bgSprite.setFixedPos(true);
    }
    public double getX() {return bgSprite.getX();}
    public double getY() {return bgSprite.getY();}
    public double getX1() {return bgSprite.getX1();}
    public double getY1() {return bgSprite.getY1();}
    public double getX2() {return bgSprite.getX2();}
    public double getY2() {return bgSprite.getY2();}
    public double getWidth() {return bgSprite.getWidth();}
    public double getHeight() {return bgSprite.getHeight();}
    public void setX(double x) {bgSprite.setX(x);}
    public void setY(double y) {bgSprite.setY(y);}
    public void setX1(double x1) {bgSprite.setX1(x1);}
    public void setX2(double x2) {bgSprite.setX2(x2);}
    public void setY1(double y1) {bgSprite.setY1(y1);}
    public void setY2(double y2) {bgSprite.setY2(y2);}
    public void setWidth(double width) {bgSprite.setWidth(width);}
    public void setHeight(double height) {bgSprite.setHeight(height);}
    public void setPos(double x1, double y1, double x2, double y2) {
        this.setX1(x1);
        this.setY1(y1);
        this.setX2(x2);
        this.setY2(y2);
    }
    public void setPos(double x, double y) {
        this.setX(x);
        this.setY(y);
    }
    public void moveX(double x) {
        this.setX(this.getX()+x);
    }
    public void moveY(double y) {
        this.setY(this.getY()+y);
    }
    public void movePos(double x, double y) {
        this.moveX(x);
        this.moveY(y);
    }
    public void setSize(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }
    @Override
    public boolean onUnhandledMouseClick() {
        return this.intersects(Mouse.mousePosX(),Mouse.mousePosY());
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if(bgSprite!=null) {
            bgSprite.paint(g2d);
        }
        super.paintComponent(g);
    }

    public boolean intersects(double x, double y) {
        return x >= this.getX1() && y >= this.getY1() && x <= this.getX2() && y <= this.getY2();
    }
}
