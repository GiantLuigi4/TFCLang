package TLangJava.Math;

public class Math {
    public float lerp(float pct, float start, float end) {
        return (start * (1 - pct) + end * pct);
    }
}
