package TLangJava.Display.ThreeDimensional;

import TLangJava.Display.TwoDimensional.Pixel;

public class Pixel3D extends Pixel {
    public float z;

    public Pixel3D(Pixel pxl, float z) {
        super(pxl.x, pxl.y, pxl.r, pxl.g, pxl.b, pxl.a);
        this.z = z;
    }

    public Pixel3D(float x, float y, float z, int r, int g, int b, int a) {
        super(x, y, r, g, b, a);
        this.z = z;
    }

    public Pixel getPixelFromOffset(Pixel3D source, Pixel3D cam) {
        return null;
    }
}
