package engine.drawHandlers;

import engine.App;
import engine.objects.BaseObject;

import javax.swing.*;
import java.awt.*;

public class ImageDraw extends DrawHandler{
    private Image baseImg;
    private Image img;
    private double currentWidth;
    private double currentHeight;
    public ImageDraw(String imgPath,double width, double height) {
        ImageIcon ii = new ImageIcon(imgPath);
        this.currentWidth = width;
        this.currentHeight = height;
        baseImg = ii.getImage();
        img = baseImg.getScaledInstance((int) currentWidth, (int) currentHeight, Image.SCALE_DEFAULT);
    }
    @Override
    public void paint(Graphics2D g2d, BaseObject object) {
        if(object.getWidth()!= currentWidth || object.getHeight() != currentHeight) {
            currentWidth = object.getWidth();
            currentHeight = object.getHeight();
            img = baseImg.getScaledInstance((int) object.getWidth(), (int) object.getHeight(), Image.SCALE_DEFAULT);
            boolean result = false;
            while (!result) {
                result = rotateAndDraw(g2d,object);
            }
        }
        else {
            rotateAndDraw(g2d,object);
        }
    }
    private boolean rotateAndDraw(Graphics2D g2d, BaseObject object) {
        boolean result;
        double x = object.getAbsX1();
        double y = object.getAbsY1();
        g2d.rotate(Math.toRadians(object.getAngle()), (int) (x+object.getWidth()/2), (int) (y+object.getHeight()/2));
        result = g2d.drawImage(this.img,(int) x,(int) y, App.getInstance().getPanel());
        g2d.rotate(Math.toRadians(-object.getAngle()), (int) (x+object.getWidth()/2), (int) (y+object.getHeight()/2));
        return result;
    }
}
