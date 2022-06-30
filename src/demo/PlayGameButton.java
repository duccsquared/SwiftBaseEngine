package demo;

import engine.App;
import engine.objects.Button;
import engine.screens.Screen;

import java.io.IOException;

public class PlayGameButton extends Button {
    public PlayGameButton(Screen screen, double x1, double y1, double x2, double y2) throws IOException {
        super(screen,"Play Game", 128,128,128,255,255,255, x1, y1, x2, y2);
        this.setFixedPos(true);
    }

    @Override
    public void onClick() {
        try {
            App.getInstance().getPanel().setCurrentScreen("game");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("button pressed");
    }

    @Override
    public void tick() {
    }
}
