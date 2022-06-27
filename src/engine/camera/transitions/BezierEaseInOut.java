package engine.camera.transitions;

public class BezierEaseInOut extends CubicBezier {
    public BezierEaseInOut(int steps) {
        super(steps,.42,0,.58,1);
    }
}
