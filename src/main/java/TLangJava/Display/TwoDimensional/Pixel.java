package TLangJava.Display.TwoDimensional;

import java.awt.*;

public class Pixel {
    public float x;
    public float y;
    public int r;
    public int g;
    public int b;
    public int a;

    public Pixel(float x, float y, int r, int g, int b, int a) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public void paint(Graphics graphics) {
        graphics.setColor(new Color(r, g, b, a));
        graphics.fillRect((int) x, (int) y, 1, 1);
    }
}
