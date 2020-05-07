package TLangJava.Display.ThreeDimensional;

import java.util.ArrayList;

public class PixelList {
	ArrayList<Pixel3D> pixels = new ArrayList<>();
	
	public PixelList(Pixel3D first) {
		pixels.add(first);
	}
	
	public void addPixel(Pixel3D pxl) {
		pixels.add(pxl);
	}
}
