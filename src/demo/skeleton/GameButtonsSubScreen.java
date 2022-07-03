package demo.skeleton;

import demo.buttons.AddEnemyButton;
import engine.screens.BaseScreen;
import engine.screens.SubScreen;

public class GameButtonsSubScreen extends SubScreen {
    public GameButtonsSubScreen(BaseScreen screen)  {
        super("GameButtons", screen, 128, 128, 128, 255, 255, 255, 20, 520, 580, 580);
        new AddEnemyButton(this,10,10,50,50);
    }

    @Override
    public void tick() {
        super.tick();
    }
}