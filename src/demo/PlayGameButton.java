package demo;

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
        System.out.println("button pressed");
    }
}
