package engine.camera.transitions;

public class TTest {
    public static void main(String[] args) {
        Tween tween = new CubicBezier(20,0.17,0.67,0.74,0.28);
        for(int i = 0; i < 20; i++) {
            tween.next();
            System.out.println(i + ":" + tween.currentPos());
        }
    }
}
