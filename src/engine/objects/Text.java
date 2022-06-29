package engine.objects;

import engine.App;
import engine.drawHandlers.DrawHandler;
import engine.drawHandlers.TextDraw;
import engine.screens.Screen;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class Text extends BaseObject {
    private static Color defaultColor = new Color(255,255,255);
    private static String defaultFontStr = "Power Green";
    private Color color;
    private Font font;
    private String string;
    private Boolean coordsFixed;
    private Text(Screen screen, DrawHandler drawHandler, double x1, double y1, double x2, double y2) throws IOException {
        super(screen, drawHandler, x1, y1, x2, y2);
    }
    public static Text newInstance(Screen screen, String string, double x1, double y1, int fontSize) throws IOException {
        return init(screen,string,x1,y1,defaultFontStr, Font.PLAIN,fontSize,defaultColor.getRed(),defaultColor.getGreen(),defaultColor.getBlue(),TextDraw.CENTER,TextDraw.CENTER,false);
    }
    public static Text newInstance(Screen screen, String string, double x1, double y1, int fontSize, int hAlign, int vAlign) throws IOException {
        return init(screen,string,x1,y1,defaultFontStr, Font.PLAIN,fontSize,defaultColor.getRed(),defaultColor.getGreen(),defaultColor.getBlue(),hAlign,vAlign,false);
    }
    public static Text newInstance(Screen screen, String string, double x1, double y1, String fontStr, int fontStyle, int fontSize, int r, int g, int b, int hAlign, int vAlign, boolean fixedPos) throws IOException {
        return init(screen,string,x1,y1,fontStr, fontStyle,fontSize,r,g,b,hAlign,vAlign,fixedPos);
    }
    public static Text init(Screen screen, String string, double x1, double y1, String fontStr, int fontStyle, int fontSize, int r, int g, int b, int hAlign, int vAlign, boolean fixedPos) throws IOException {
        Font font = new Font(fontStr,fontStyle,fontSize);
        double[] coords = getCoordsFromFontSize(font,string,x1,y1);
        double width = coords[2] - coords[0]; double height = coords[3] - coords[1];
        if(hAlign==TextDraw.CENTER) {
            coords[2] -= width/2;
            coords[0] -= width/2;
        }
        if(hAlign==TextDraw.RIGHT) {
            coords[2] -= width;
            coords[0] -= width;
        }
        if(vAlign==TextDraw.CENTER) {
            coords[3] -= height/2;
            coords[1] -= height/2;
        }
        if(vAlign==TextDraw.BOTTOM) {
            coords[3] -= height;
            coords[1] -= height;
        }
        Text text = new Text(screen, new TextDraw(hAlign,vAlign),coords[0],coords[1],coords[2],coords[3]);
        text.setFixedPos(fixedPos);
        text.coordsFixed = true;
        text.string = string;
        text.font = font;
        text.color = new Color(r,g,b);
        return text;
    }
    public Color getColor() {return color;}
    public Font getFont() {return font;}
    public String getString() {return string;}
    // string width/height
    public int getStringWidth() {
        Graphics g = App.getInstance().getPanel().getGraphics();
        Rectangle2D r = g.getFontMetrics(this.getFont()).getStringBounds(this.getString(),g);
        return (int) r.getWidth();
    }
    public int getStringHeight() {
        Graphics g = App.getInstance().getPanel().getGraphics();
        Rectangle2D r = g.getFontMetrics(this.getFont()).getStringBounds(this.getString(),g);
        return (int) -r.getY();
    }
    public static double[] getCoordsFromFontSize(Font font, String string, double x1, double y1) {
        // return format: {x1,y1,x2,y2}
        Graphics g = App.getInstance().getPanel().getGraphics();
        Rectangle2D r = g.getFontMetrics(font).getStringBounds(string,g);
        return new double[] {x1,y1,x1+r.getWidth(),y1-r.getY()};
    }
}
