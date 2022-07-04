package engine.managers;

import engine.utils.Mouse;
import engine.objects.BaseObject;

public class DragManager {
    BaseObject object = null;
    double relX = 0;
    double relY = 0;
    public void startDragging(BaseObject object) {
        this.object = object;
        this.relX = object.getX() - Mouse.relMousePosX(object.getScreen());
        this.relY = object.getY() - Mouse.relMousePosY(object.getScreen());
    }
    public void tick() {
        if(!Mouse.leftHeld()) {
            object = null;
        }
        if(object!=null) {
            if(object.isFixedPos()) {object.setPos(Mouse.mousePosX()+relX,Mouse.mousePosY()+relY);}
            else {object.setPos(Mouse.relMousePosX(object.getScreen())+relX,Mouse.relMousePosY(object.getScreen())+relY);}
            object.onDrag();
        }
    }
    public BaseObject getObject() {return object;}
}
