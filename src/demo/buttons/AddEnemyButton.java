package demo.buttons;

import demo.Global;
import demo.objects.Enemy;
import engine.objects.Button;
import engine.objects.Tooltip;
import engine.screens.Screen;

public class AddEnemyButton extends Button {
    public AddEnemyButton(Screen screen,double x1, double y1, double x2, double y2)  {
        super(screen, "", "src/demo/res/addEnemyButton.png", x1, y1, x2, y2);
        Tooltip.newInstance(screen,this,"Add Enemy");
    }

    @Override
    public void onClick() {
        double x = Global.randInt(-100,700);
        double y =  Global.randInt(-100,700);
        new Enemy((this.getScreen()).root(),x,y);
    }
}