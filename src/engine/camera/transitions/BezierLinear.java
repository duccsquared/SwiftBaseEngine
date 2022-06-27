package engine.camera.transitions;

public class BezierLinear extends CubicBezier {
    public BezierLinear(int steps) {
        super(steps,0,0,1,1);
    }
}
