package demo;

import demo.skeleton.DemoPanel;
import engine.skeleton.App;
import engine.exceptions.AppNotInstantiatedException;

public class Main {
    public static void main(String[] args) throws AppNotInstantiatedException {
        App.instantiate("Demo",600,600,new DemoPanel());
    }
}
