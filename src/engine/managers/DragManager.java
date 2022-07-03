package engine.managers;

import engine.utils.Mouse;
import engine.objects.BaseObject;

public class DragManager {
    BaseObject object = null;
    double relX = 0;
    double relY = 0;
    public void startDragging(BaseObject object) {
        this.object = object;
        this.relX = object.getX() - Mouse.relMousePosX();
        this.relY = object.getY() - Mouse.relMousePosY();
    }
    public void tick() {
        if(!Mouse.leftHeld()) {
            object = null;
        }
        if(object!=null) {
            if(object.isFixedPos()) {object.setPos(Mouse.mousePosX()+relX,Mouse.mousePosY()+relY);}
            else {object.setPos(Mouse.relMousePosX()+relX,Mouse.relMousePosY()+relY);}
        }
    }
    public BaseObject getObject() {return object;}
}
