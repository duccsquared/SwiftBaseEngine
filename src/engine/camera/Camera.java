package engine.camera;

import engine.objects.BaseObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Camera {
    private double x = 0;
    private double y = 0;
    private ObjectAttacher objectAttacher = null;
    public double x() {return x;}
    public double y() {return y;}
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void attachObject(BaseObject object) {
        this.objectAttacher = new ObjectAttacher(this,object);
    }
    public void updateCameraPos() {
        if(objectAttacher!=null) {
            this.x = objectAttacher.x();
            this.y = objectAttacher.y();
        }
    }
}
