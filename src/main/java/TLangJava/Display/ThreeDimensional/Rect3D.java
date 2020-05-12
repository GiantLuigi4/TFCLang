package TLangJava.Display.ThreeDimensional;

import java.util.ArrayList;

public class Rect3D {
	Line3D line1;
	Line3D line2;
	ThreeDimensionalImage image;
	
	public Rect3D(Line3D line1, Line3D line2) {
		this.line1 = line1;
		this.line2 = line2;
	}
	
	public void prep() {
		ArrayList<Pixel3D> pixels = new ArrayList<>();
		int i = 0;
		ArrayList<Pixel3D> lne1 = line1.getAllPixels(0.275f / line1.getLength());
		ArrayList<Pixel3D> lne2 = line2.getAllPixels(0.275f / line2.getLength());
		for (i = 0; i < lne1.size(); i++) {
			try {
				float progress = (float) i / (float) lne1.size();
				Line3D line = new Line3D(lne1.get((int) (progress * lne1.size())), lne2.get((int) (progress * lne2.size())));
				pixels.addAll(line.getAllPixels(0.1f / line.getLength()));
			} catch (Exception err) {
			}
		}
		pixels.addAll(lne1);
		pixels.addAll(lne2);
		image = new ThreeDimensionalImage(pixels);
//		pxls=new ArrayList<>();
//		for (Pixel3D pxl:image.getPixels()) {
//			pxls.add(new Pixel3D((int)pxl.x,(int)pxl.z,(int)pxl.y,pxl.r,pxl.g,pxl.b,pxl.a));
//		}
	}
}
