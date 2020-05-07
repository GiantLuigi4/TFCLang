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
    
    public static Pixel3D getPixelFromOffset(Pixel3D source, Pixel3D cam) {
        float X = source.x - cam.x;
        float Y = source.y - cam.y;
        float Z = source.z - cam.z;
        float x = (float) ((Math.cos(0) * X) - (Math.sin(0) * Y));
        float y = (float) ((Math.cos(0) * ((Math.cos(0) * Y) + (Math.sin(0) * X))) + (Z * Math.sin(0)));
        float negativeX = 1;
        if (("" + x).startsWith("-")) {
            negativeX = -1;
        }
        float negativeY = 1;
        if (("" + y).startsWith("-")) {
            negativeY = -1;
        }
        float offset = (5 / (source.z - cam.z));
        x *= offset;
        y *= offset;
        return new Pixel3D(x, y, offset, source.r, source.g, source.b, source.a);
    }
    
    public static float getDistance(Pixel3D pos1, Pixel3D pos2) {
        float xDist = Math.abs(pos1.x - pos2.x);
        float yDist = Math.abs(pos1.y - pos2.y);
        float zDist = Math.abs(pos1.z - pos2.z);
        return (xDist * xDist) + (yDist * yDist) + (zDist * zDist);
    }
    
    public Pixel3D rotate(Pixel3D origin, float x) {
        this.x -= origin.x;
        this.y -= origin.y;
        this.z -= origin.z;
        this.x = (float) (Math.cos(x) * this.x) + origin.x;
        this.z = (float) (Math.sin(x) * this.z) + origin.z;
        return this;
    }
}
