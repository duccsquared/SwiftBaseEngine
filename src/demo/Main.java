package demo;

import engine.App;
import engine.Panel;
import engine.exceptions.AppNotInstantiatedException;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws AppNotInstantiatedException {
        App.instantiate("Demo",600,600,new DemoPanel());
    }
}
