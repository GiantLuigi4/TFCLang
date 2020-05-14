package TLangJava.Math;

public class Smoothing {
    public static float lerp(float pct, float start, float end) {
        return (start * (1 - pct) + end * pct);
    }
}
