package demo;

import engine.objects.Sprite;
import engine.screens.Screen;

import java.awt.*;
import java.io.IOException;

public class PlayerSubpart extends Sprite {
    public PlayerSubpart(Screen screen, Player player, double x, double y, double angle) throws IOException {
        super(screen, "src/demo/res/playerPart.png", player.getX()+x-15,player.getY()+y-15,player.getX()+x+15,player.getY()+y+15);
        this.setAngle(angle);
        this.setParent(player);
    }


}
