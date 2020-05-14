package TLangJava.Display.ThreeDimensional;

import TLangJava.Math.Smoothing;

import java.awt.geom.Line2D;
import java.util.ArrayList;

//TODO
public class Line3D {
    public Pixel3D pos1;
    public Pixel3D pos2;
    
    public Line3D(Pixel3D pos1, Pixel3D pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }
    
    public static Pixel3D averagePixels(Pixel3D posa, Pixel3D posb) {
        float newX = (posa.x + posb.x) / 2;
        float newY = (posa.y + posb.y) / 2;
        float newZ = (posa.z + posb.z) / 2;
        int newR = (posa.r + posb.r) / 2;
        int newG = (posa.g + posb.g) / 2;
        int newB = (posa.b + posb.b) / 2;
        int newA = (posa.a + posb.a) / 2;
        return new Pixel3D(newX, newY, newZ, newR, newG, newB, newA);
    }
    
    public float getLength() {
        float xDist = Math.abs(pos1.x - pos2.x);
        float yDist = Math.abs(pos1.y - pos2.y);
        float zDist = Math.abs(pos1.z - pos2.z);
        return xDist + yDist + zDist;
    }

    public static Pixel3D lerp(float Dist, Pixel3D start, Pixel3D end) {
        float newX = Smoothing.lerp(Dist, start.x, end.x);
//        float newX = ((start.x * (1 - Dist)) + (end.x * Dist));
        float newY = Smoothing.lerp(Dist, start.y, end.y);
//        float newY = ((start.y * (1 - Dist)) + (end.y * Dist));
        float newZ = Smoothing.lerp(Dist, start.z, end.z);
//        float newZ = ((start.z * (1 - Dist)) + (end.z * Dist));
        int newR = (int) Smoothing.lerp(Dist, start.r, end.r);
//        int newR = (int) ((start.r * (1 - Dist)) + (end.r * Dist));
        int newG = (int) Smoothing.lerp(Dist, start.g, end.g);
//        int newG = (int) ((start.g * (1 - Dist)) + (end.g * Dist));
        int newB = (int) Smoothing.lerp(Dist, start.b, end.b);
//        int newB = (int) ((start.b * (1 - Dist)) + (end.b * Dist));
        int newA = (int) Smoothing.lerp(Dist, start.a, end.a);
//        int newA = (int) ((start.a * (1 - Dist)) + (end.a * Dist));
        return new Pixel3D(newX, newY, newZ, newR, newG, newB, newA);
    }

    public ArrayList<Pixel3D> getAllPixels(float precision) {
        ArrayList<Pixel3D> pxls = new ArrayList<>();
        for (float i = 0; i <= 1; i += precision) {
            pxls.add(lerp(i, pos1, pos2));
        }
        return pxls;
    }
    
    public Line2D as2D() {
        return null;
    }
}
