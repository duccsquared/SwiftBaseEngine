package demo;

import engine.objects.Button;
import engine.screens.Screen;
import engine.screens.SubScreen;

import java.io.IOException;
import java.util.Random;

public class AddEnemyButton extends Button {
    Random random = new Random();
    public AddEnemyButton(Screen screen,double x1, double y1, double x2, double y2) throws IOException {
        super(screen, "", "src/demo/res/addEnemyButton.png", x1, y1, x2, y2);
    }

    @Override
    public void tick() {
    }

    @Override
    public void onClick() {
        double x = random.nextDouble() * 800 - 100;
        double y = random.nextDouble() * 800 - 100;
        try {
            new Enemy(((SubScreen) this.getScreen()).parent(),x,y);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
