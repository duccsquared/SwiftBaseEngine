package demo.skeleton;

import demo.buttons.AddEnemyButton;
import engine.objects.Tooltip;
import engine.objects.slider.Slider;
import engine.screens.BaseScreen;
import engine.screens.SubScreen;
import engine.utils.Key;

public class GameButtonsSubScreen extends SubScreen {
    Slider slider;
    AddEnemyButton addEnemyButton;
    public GameButtonsSubScreen(BaseScreen screen)  {
        super("GameButtons", screen, 128, 128, 128, 255, 255, 255, 20, 520, 580, 580);
        addEnemyButton = new AddEnemyButton(this,10,10,50,50);
        slider = new Slider(this,70,10,540,50,0,10,1);
        Tooltip.newInstance(this,slider.getSliderNotch(),"Enemies spawned per click");
    }

    @Override
    public void tick() {
        super.tick();
        if(Key.pressed(Key.KEY_1)) {
            slider.setValue(0);
        }
        if(Key.pressed(Key.KEY_2)) {
            slider.setValue(5);
        }
        if(Key.pressed(Key.KEY_3)) {
            slider.setValue(100);
        }
        addEnemyButton.setEnemiesAddedPerClick(slider.value());
    }
}
