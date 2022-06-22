package engine.objects;

import engine.drawHandlers.DrawHandler;
import engine.screens.Screen;

import java.awt.*;
import java.io.IOException;

public abstract class BaseObject {
    private Screen screen;
    private double x;
    private double y;
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private double width;
    private double height;
    private boolean fixedPos = false;
    private double angle = 0;
    private boolean sizeChangeFlag = false;
    private DrawHandler drawHandler;
    public BaseObject(Screen screen, DrawHandler drawHandler, double x1, double y1, double x2, double y2) throws IOException {
        this.init(screen,drawHandler,x1,y1,x2,y2);
    }
    public void init(Screen screen, DrawHandler drawHandler, double x1, double y1, double x2, double y2) throws IOException {
        this.screen = screen;
        this.drawHandler = drawHandler;
        screen.addObject(this);
        this.setPos(x1,y1,x2,y2);
    }
    public double getX() {return x;}
    public double getY() {return y;}
    public double getX1() {return x1;}
    public double getY1() {return y1;}
    public double getX2() {return x2;}
    public double getY2() {return y2;}
    public double getWidth() {return width;}
    public double getHeight() {return height;}
    public double getAngle() {return angle;}
    public void setX(double x) {
        this.x = x;
        this.x1 = x - this.getWidth()/2;
        this.x2 = x + this.getWidth()/2;
    }
    public void setY(double y) {
        this.y = y;
        this.y1 = y - this.getHeight()/2;
        this.y2 = y + this.getHeight()/2;
    }
    public void setX1(double x1) {
        this.x1 = x1;
        this.width = this.x2 - this.x1;
        this.x = (this.x1 + this.x2)/2;
        this.sizeChangeFlag = true;
    }
    public void setX2(double x2) {
        this.x2 = x2;
        this.width = this.x2 - this.x1;
        this.x = (this.x1 + this.x2)/2;
        this.sizeChangeFlag = true;
    }
    public void setY1(double y1) {
        this.y1 = y1;
        this.height = this.y2 - this.y1;
        this.y = (this.y1 + this.y2)/2;
        this.sizeChangeFlag = true;
    }
    public void setY2(double y2) {
        this.y2 = y2;
        this.height = this.y2 - this.y1;
        this.y = (this.y1 + this.y2)/2;
        this.sizeChangeFlag = true;
    }
    public void setWidth(double width) {
        this.width = width;
        this.x1 = this.x - this.getWidth()/2;
        this.x2 = this.x + this.getWidth()/2;
        this.sizeChangeFlag = true;
    }
    public void setHeight(double height) {
        this.height = height;
        this.y1 = this.y - this.getHeight()/2;
        this.y2 = this.y + this.getHeight()/2;
        this.sizeChangeFlag = true;
    }
    public void setAngle(double angle) {this.angle = angle;}
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
    public void tick() {

    }
    public void paint(Graphics2D g2d) {
        drawHandler.paint(g2d,this);
    }
}
