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
	}
	
	public ArrayList<Pixel3D> getPixels() {
		ArrayList<Pixel3D> returnVal = new ArrayList<>();
		for (int k = ZPoses.length - 1; k >= 0; k--) {
			float f = ZPoses[k];
			returnVal.addAll(pixels.get(f).pixels);
		}
//		Object[] keys=pixels.keySet().toArray();
//		for (int i=0;i<pixels.keySet().size();i++) {
//			for (int b=0;b<pixels.keySet().size();b++) {
//				if ((float)keys[i]<=(float)keys[b]) {
//					float f1=(float)keys[i];
//					float f2=(float)keys[b];
//					keys[i]=f2;
//					keys[b]=f1;
////					Main.TLangDebug.print(LogLevel.WARN,""+f1+","+f2);
//				}
//			}
//		}
//		for (Object f:keys) {
//			returnVal.addAll(pixels.get(f).pixels);
//		}
		return returnVal;
	}
}
