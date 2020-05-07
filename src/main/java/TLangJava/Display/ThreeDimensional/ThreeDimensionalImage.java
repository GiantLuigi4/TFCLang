package TLangJava.Display.ThreeDimensional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class ThreeDimensionalImage {
	float minZ;
	float maxZ;
	ArrayList<Float> zPoses = new ArrayList<>();
	private HashMap<Float, PixelList> pixels = new HashMap<>();
	
	public ThreeDimensionalImage(ArrayList<Pixel3D> pixels) {
		for (Pixel3D pxl : pixels) {
			if (pxl.z <= minZ) {
				minZ = pxl.z;
			}
			if (pxl.z >= maxZ) {
				maxZ = pxl.z;
			}
			if (!zPoses.contains(pxl.z)) {
				zPoses.add(pxl.z);
			}
			if (this.pixels.containsKey(pxl.z)) {
				this.pixels.get(pxl.z).addPixel(pxl);
			} else {
				this.pixels.put(pxl.z, new PixelList(pxl));
			}
		}
		zPoses.sort(new Comparator<Float>() {
			@Override
			public int compare(Float aFloat, Float t1) {
				if (aFloat < t1) {
					return -1;
				} else if (aFloat > t1) {
					return 1;
				}
				return 0;
			}
		});
	}
	
	public ArrayList<Pixel3D> getPixels() {
		ArrayList<Pixel3D> returnVal = new ArrayList<>();
		for (float f : zPoses) {
			for (Pixel3D pxl : pixels.get(f).pixels) {
				returnVal.add(pxl);
			}
		}
		return returnVal;
	}
}
