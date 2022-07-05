package demo.objects.player;

import engine.objects.Sprite;
import engine.screens.Screen;

public class PlayerSubpart extends Sprite {
    public PlayerSubpart(Screen screen, Player player, double x, double y, double angle) {
        super(screen, "src/demo/res/playerPart.png", player.x()+x-15,player.y()+y-15,player.x()+x+15,player.y()+y+15);
        this.setAngle(angle);
        this.setParent(player);
    }


}
