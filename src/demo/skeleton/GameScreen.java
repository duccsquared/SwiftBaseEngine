package demo.skeleton;

import demo.objects.Obstacle;
import demo.objects.player.Player;
import engine.managers.ObjectInstanceManager;
import engine.utils.Key;
import engine.screens.BaseScreen;

public class GameScreen extends BaseScreen {
    private Player player;

    public GameScreen(String id) {
        super(id);
        new Obstacle(this,100,100,200,200);
        new Obstacle(this,400,500,550,550);
        new Obstacle(this,300,650,900,700);
        new Obstacle(this,-100,200,-50,300);
        new Obstacle(this,600,-200,650,-150);
        new Obstacle(this,600,250,650,300);
        new Obstacle(this,-150,700,50,750);
        new Obstacle(this,300,-400,400,-300);
        player = new Player(this,280,280,320,320);

        this.getCamera().attachObject(player);
        this.addSubScreen(new GameButtonsSubScreen(this));
    }

    @Override
    public boolean onUnhandledMouseClick() {
        player.attemptToShoot();
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if(Key.pressed(Key.O)) {
            this.getCamera().panTo(-300,-300);
        }
        if(Key.pressed(Key.P)) {
            this.getCamera().panTo(0,0);
        }
        if(Key.pressed(Key.I)) {
            System.out.println(ObjectInstanceManager.getInstance().getArrayList(Obstacle.class).size());
        }
    }
}
