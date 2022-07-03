package demo.skeleton;

import demo.buttons.PlayGameButton;
import engine.objects.Text;
import engine.screens.BaseScreen;

public class MainMenuScreen extends BaseScreen {
    public MainMenuScreen(String id) {
        super(id);
        Text.newInstance(this,"Swift Base Engine",300,150,40);
        Text.newInstance(this,"Demo Game",300,200,40);
        new PlayGameButton(this,200,300,400,400);
    }

    @Override
    public void tick() {
        super.tick();
    }
}
