package engine;

public class AABB {
    private double x;
    private double y;
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private double width;
    private double height;
    public double getX() {return x;}
    public double getY() {return y;}
    public double getX1() {return x1;}
    public double getY1() {return y1;}
    public double getX2() {return x2;}
    public double getY2() {return y2;}
    public double getWidth() {return width;}
    public double getHeight() {return height;}
    public void setX(double x) {
        this.x = x;
        this.x1 = x - this.getWidth()/2;
        this.x2 = x + this.getWidth()/2;
    }
    public void setY(double y) {
        this.y = y;
        this.y1 = y - this.getHeight()/2;
        this.y2 = y + this.getHeight()/2;
    }
    public void setX1(double x1) {
        this.x1 = x1;
        this.width = this.x2 - this.x1;
        this.x = (this.x1 + this.x2)/2;
    }
    public void setX2(double x2) {
        this.x2 = x2;
        this.width = this.x2 - this.x1;
        this.x = (this.x1 + this.x2)/2;
    }
    public void setY1(double y1) {
        this.y1 = y1;
        this.height = this.y2 - this.y1;
        this.y = (this.y1 + this.y2)/2;
    }
    public void setY2(double y2) {
        this.y2 = y2;
        this.height = this.y2 - this.y1;
        this.y = (this.y1 + this.y2)/2;
    }
    public void setWidth(double width) {
        this.width = width;
        this.x1 = this.x - this.getWidth()/2;
        this.x2 = this.x + this.getWidth()/2;
    }
    public void setHeight(double height) {
        this.height = height;
        this.y1 = this.y - this.getHeight()/2;
        this.y2 = this.y + this.getHeight()/2;
    }
}
