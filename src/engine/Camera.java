package engine;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Camera {
    private double x = 0;
    private double y = 0;
    public double x() {return x;}
    public double y() {return y;}
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void attachToEntity() {
        throw new NotImplementedException();
    }

}
