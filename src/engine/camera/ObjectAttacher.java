package engine.camera;

import engine.exceptions.CantAttachCameraToFixedObjectException;
import engine.exceptions.ExceptionThrower;
import engine.objects.BaseObject;

public class ObjectAttacher {
    private BaseObject object;
    private double relX;
    private double relY;
    protected ObjectAttacher(Camera camera, BaseObject object) {
        if(object.isFixedPos()) {
            ExceptionThrower.throwException(new CantAttachCameraToFixedObjectException());
        }
        this.object = object;
        relX = object.getX1() - camera.x();
        relY = object.getY1() - camera.y();
    }
    public double x() {
        return object.getX1() + relX;
    }
    public double y() {
        return object.getY1() + relY;
    }
}
