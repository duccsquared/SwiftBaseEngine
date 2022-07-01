package engine.objects;

import demo.Obstacle;
import engine.AABB;
import engine.ObjectInstanceManager;
import engine.drawHandlers.DrawHandler;
import engine.screens.BaseScreen;
import engine.screens.Screen;
import engine.screens.SubScreen;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class BaseObject {
    private Screen screen;
    AABB aabb;
    private boolean fixedPos = false;
    private double angle = 0;
    private DrawHandler drawHandler;
    public BaseObject(Screen screen, DrawHandler drawHandler, double x1, double y1, double x2, double y2) throws IOException {
        this.init(screen,drawHandler,x1,y1,x2,y2);
    }
    public void init(Screen screen, DrawHandler drawHandler, double x1, double y1, double x2, double y2) throws IOException {
        this.screen = screen;
        this.drawHandler = drawHandler;
        screen.addObject(this);
        this.aabb = new AABB();
        this.setPos(x1,y1,x2,y2);
    }
    public boolean isFixedPos() {return fixedPos;}
    public Screen getScreen() {return screen;}
    public double getX() {return aabb.getX();}
    public double getY() {return aabb.getY();}
    public double getX1() {return aabb.getX1();}
    public double getY1() {return aabb.getY1();}
    public double getX2() {return aabb.getX2();}
    public double getY2() {return aabb.getY2();}
    public double getWidth() {return aabb.getWidth();}
    public double getHeight() {return aabb.getHeight();}
    public double getAngle() {return angle;}
    public double getAbsX1() {
        double x1;
        if(fixedPos) {x1 = this.getX1();}
        else {x1 = this.getX1() - screen.windowX();}
        if(screen instanceof SubScreen) {
            x1 += ((SubScreen) screen).getX1();
        }
        return x1;
    }
    public double getAbsY1() {
        double y1;
        if(fixedPos) {y1 = this.getY1();}
        else {y1 = this.getY1() - screen.windowY();}
        if(screen instanceof SubScreen) {
            y1 += ((SubScreen) screen).getY1();
        }
        return y1;
    }
    public double getAbsX2() {
        return getAbsX1() + this.getWidth();
    }
    public double getAbsY2() {
        return getAbsY1() + this.getHeight();
    }
    public void setFixedPos(boolean fixedPos) {this.fixedPos = fixedPos;}
    public void setX(double x) {aabb.setX(x);}
    public void setY(double y) {aabb.setY(y);}
    public void setX1(double x1) {aabb.setX1(x1);}
    public void setX2(double x2) {aabb.setX2(x2);}
    public void setY1(double y1) {aabb.setY1(y1);}
    public void setY2(double y2) {aabb.setY2(y2);}
    public void setWidth(double width) {aabb.setWidth(width);}
    public void setHeight(double height) {aabb.setHeight(height);}
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
    public boolean intersects(double x, double y) {
        return x >= this.getX1() && y >= this.getY1() && x <= this.getX2() && y <= this.getY2();
    }
    public boolean intersectsAbs(double x, double y) {
        return x >= this.getAbsX1() && y >= this.getAbsY1() && x <= this.getAbsX2() && y <= this.getAbsY2();
    }
    public boolean intersects(BaseObject baseObject) {
        return this.getX1() < baseObject.getX2() &&
                this.getX2() > baseObject.getX1() &&
                this.getY1() < baseObject.getY2() &&
                this.getY2() > baseObject.getY1();
    }
    public void resolveCollisionsX(Class<? extends BaseObject> cls, double dirX) {
        ArrayList<BaseObject> objectArray = ObjectInstanceManager.getInstance().getArrayList(cls,this.getScreen());
        if(dirX==0){return;}
        for(BaseObject object: objectArray) {
            while(this.intersects(object)) {
                this.moveX(Math.signum(dirX));
            }
        }
    }
    public void resolveCollisionsY(Class<? extends BaseObject> cls, double dirY) {
        ArrayList<BaseObject> objectArray = ObjectInstanceManager.getInstance().getArrayList(cls,this.getScreen());
        if(dirY==0){return;}
        for(BaseObject object: objectArray) {
            while(this.intersects(object)) {
                this.moveY(Math.signum(dirY));
            }
        }
    }
    public void resolveCollisions(Class<? extends BaseObject> cls, double dirX, double dirY) {
        resolveCollisionsX(cls,dirX);
        resolveCollisionsY(cls,dirY);
    }
    public void delete() {
        this.screen.removeObject(this);
    }
    public  abstract void tick();
    public boolean tickMouse() {
        return false;
    }
    public void paint(Graphics2D g2d) {
        drawHandler.paint(g2d,this);
    }
}
