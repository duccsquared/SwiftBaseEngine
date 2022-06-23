package engine.camera;

import engine.camera.transitions.CubicBezier;
import engine.camera.transitions.Transition;
import engine.objects.BaseObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Camera {
    private double x = 0;
    private double y = 0;
    private ObjectAttacher objectAttacher = null;
    private Transition transition = null;
    public double x() {return x;}
    public double y() {return y;}
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void attachObject(BaseObject object) {
        this.objectAttacher = new ObjectAttacher(this,object);
    }
    public void panTo(double x, double y) {
        objectAttacher = null;
        transition = new Transition(this.x,this.y,x,y,100,new CubicBezier(100,.25,.1,.25,1));
    }
    public void updateCameraPos() {
        if(objectAttacher!=null) {
            this.x = objectAttacher.x();
            this.y = objectAttacher.y();
        }
        if(transition!=null) {
            if(transition.isActive()) {
                transition.next();
                setX(transition.x());
                setY(transition.y());
            }
            else {
                transition = null;
            }
        }
    }
}
