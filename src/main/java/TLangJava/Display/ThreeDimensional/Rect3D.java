package TLangJava.Display.ThreeDimensional;

import java.util.ArrayList;

public class Rect3D {
	Line3D line1;
	Line3D line2;
	//	ThreeDimensionalImage image;
	ArrayList<Pixel3D> pixels;
	
	public Rect3D(Line3D line1, Line3D line2) {
		this.line1 = line1;
		this.line2 = line2;
	}
	
	public void rotateX(Pixel3D origin, float angle) {
		line1 = new Line3D(line1.pos1.rotateX(origin, angle), line1.pos2.rotateX(origin, angle));
		line2 = new Line3D(line2.pos1.rotateX(origin, angle), line2.pos2.rotateX(origin, angle));
	}
	
	public void setupTransformation(Pixel3D origin, int minZ) {
		line1 = new Line3D(
				Pixel3D.getPixelFromOffset(Pixel3D.getPixelFromOffset(line1.pos1.rotateY(origin, 0), origin), origin),
				Pixel3D.getPixelFromOffset(Pixel3D.getPixelFromOffset(line1.pos2.rotateY(origin, 0), origin), origin)
		);
		line2 = new Line3D(
				Pixel3D.getPixelFromOffset(Pixel3D.getPixelFromOffset(line2.pos1.rotateY(origin, 0), origin), origin),
				Pixel3D.getPixelFromOffset(Pixel3D.getPixelFromOffset(line2.pos2.rotateY(origin, 0), origin), origin)
		);
	}
	
	public void prep() {
		pixels = new ArrayList<>();
		int i = 0;
		ArrayList<Pixel3D> lne1 = line1.getAllPixels(0.1f / line1.getLength());
		ArrayList<Pixel3D> lne2 = line2.getAllPixels(0.1f / line2.getLength());
		for (i = 0; i < lne1.size(); i++) {
			try {
				float progress = (float) i / (float) lne1.size();
				Line3D line = new Line3D(lne1.get((int) (progress * lne1.size())), lne2.get((int) (progress * lne2.size())));
				pixels.addAll(line.getAllPixels(0.1f / line.getLength()));
			} catch (Exception ignored) {
			}
		}
//		image = new ThreeDimensionalImage(pixels);
//		pxls=new ArrayList<>();
//		for (Pixel3D pxl:image.getPixels()) {
//			pxls.add(new Pixel3D((int)pxl.x,(int)pxl.z,(int)pxl.y,pxl.r,pxl.g,pxl.b,pxl.a));
//		}
	}
}
