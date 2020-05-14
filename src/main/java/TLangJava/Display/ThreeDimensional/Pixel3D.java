package TLangJava.Display.ThreeDimensional;

import TLangJava.Display.TwoDimensional.Pixel;
import TLangJava.Math.Trig;

import java.awt.*;

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
	
	public Pixel3D round() {
		x = (int) x;
		y = (int) y;
		z = (int) z;
		return this;
	}
	
	static double cos0 = Math.cos(0);
	static double sin0 = Math.sin(0);
    
    public static Pixel3D getPixelFromOffset(Pixel3D source, Pixel3D cam) {
        float X = cam.x - source.x;
        float Y = source.y - cam.y;
        float Z = source.z - cam.z;
		float x = (float) ((cos0 * X) - (sin0 * Y));
		float y = (float) ((cos0 * ((cos0 * Y) + (sin0 * X))) + (Z * sin0));
        float negativeX = 1;
        if (("" + x).startsWith("-")) {
            negativeX = -1;
        }
        float negativeY = 1;
        if (("" + y).startsWith("-")) {
            negativeY = -1;
        }
        float offset = (5 / (Z));
        x *= offset;
        y *= offset;
//        x += offset*negativeX;
		y += offset;
        return new Pixel3D(x, y, offset, source.r, source.g, source.b, source.a);
    }
    
    public static float getDistance(Pixel3D pos1, Pixel3D pos2) {
        float xDist = Math.abs(pos1.x - pos2.x);
        float yDist = Math.abs(pos1.y - pos2.y);
        float zDist = Math.abs(pos1.z - pos2.z);
        return (xDist * xDist) + (yDist * yDist) + (zDist * zDist);
    }
	
	public Pixel3D colorize(Color col) {
		this.r = col.getRed();
		this.g = col.getGreen();
		this.b = col.getBlue();
		this.a = col.getAlpha();
		return this;
	}
	
	public Pixel3D rotateX(Pixel3D origin, float x) {
		this.x -= origin.x;
		this.y -= origin.y;
		this.z -= origin.z;
		float rot = (float) Math.atan2(this.x, this.z) + x;
		float offset = (float) Math.sqrt(this.x * this.x + this.z * this.z);
		this.x = (float) (Trig.cos(rot, false) * offset) + origin.x;
		this.y += origin.y;
		this.z = (float) (Trig.sin(rot, false) * offset) + origin.z;
		return this;
	}
	
	public Pixel3D rotateY(Pixel3D origin, float y) {
		this.x -= origin.x;
		this.y -= origin.y;
		this.z -= origin.z;
		float rot = (float) Math.atan2(this.y, this.z) + y;
		float offset = (float) Math.sqrt(this.y * this.y + this.z * this.z);
		this.x += origin.x;
		this.y = (float) (Trig.sin(rot, false) * offset) + origin.y;
		this.z = (float) (Trig.cos(rot, false) * offset) + origin.z;
		return this;
	}
	
	public Pixel3D offset(Pixel3D off) {
		this.x += off.x;
		this.y += off.y;
		this.z += off.z;
		return this;
	}
	
	@Override
	public String toString() {
		return "Pixel3D{" +
				"x=" + x +
				", y=" + y +
				", z=" + z +
				", r=" + r +
				", g=" + g +
				", b=" + b +
				", a=" + a +
				'}';
	}
	
	public String xyz() {
		return "Pixel3D{" +
				"x=" + x +
				", y=" + y +
				", z=" + z +
				'}';
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pixel3D) {
			return ((Pixel3D) obj).xyz().equals(this.xyz());
		}
		return super.equals(obj);
	}
}
