package TLangJava.Display.ThreeDimensional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ThreeDimensionalImage {
	float minZ;
	float maxZ;
	ArrayList<Float> zPoses = new ArrayList<>();
	private HashMap<Float, PixelList> pixels = new HashMap<>();
	float[] ZPoses;

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
		ZPoses = new float[zPoses.size()];
		for (int i = 0; i < zPoses.size(); i++) {
			ZPoses[i] = zPoses.get(i);
		}
		Arrays.sort(ZPoses);
		Arrays.parallelSort(ZPoses);
	}
	
	public ArrayList<Pixel3D> getPixels() {
		ArrayList<Pixel3D> returnVal = new ArrayList<>();
		for (float f : ZPoses) {
			for (Pixel3D pxl : pixels.get(f).pixels) {
				returnVal.add(pxl);
			}
		}
		return returnVal;
	}
}
