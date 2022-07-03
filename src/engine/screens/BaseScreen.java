package engine.screens;

import engine.App;
import engine.objects.BaseObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public abstract class BaseScreen extends Screen {
    public BaseScreen(String id) {
        super(id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        this.handleMouseClick();
    }
}
