package demo.objects.player;

import demo.Global;
import engine.utils.Mouse;
import engine.objects.Sprite;
import engine.screens.Screen;

public class Turret extends Sprite {
    public Turret(Screen screen, double x, double y) {
        super(screen, "src/demo/res/turretHead.png", x-30,y-30,x+30,y+30);
    }

    @Override
    public void tick() {
        this.setAngle(Global.coorToDir(this.x(),this.y(), Mouse.relMousePosX(this.getScreen()),Mouse.relMousePosY(this.getScreen())));
    }
}
