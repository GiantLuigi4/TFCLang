package TLangJava.Display.ThreeDimensional;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TexturedRect3D extends Rect3D {
	private BufferedImage bimig;
	private int u;
	private int v;
	private int texWidth;
	private int texHeight;
	
	public TexturedRect3D(Line3D line1, Line3D line2, BufferedImage bimig, int u, int v, int texWidth, int texHeight) {
		super(line1, line2);
		this.bimig = bimig;
		this.u = u;
		this.v = v;
		this.texWidth = texWidth;
		this.texHeight = texHeight;
	}
	
	@Override
	public void prep() {
		pixels = new ArrayList<>();
		int i = 0;
		ArrayList<Pixel3D> lne1 = line1.getAllPixels(0.2f / line1.getLength());
		ArrayList<Pixel3D> lne2 = line2.getAllPixels(0.2f / line2.getLength());
		for (i = 0; i < lne1.size(); i++) {
			try {
				float progress = (float) i / (float) lne1.size();
				float texX = ((progress) * texWidth) + u;
				Line3D line = new Line3D(lne1.get((int) (progress * lne1.size())), lne2.get((int) (progress * lne2.size())));
				ArrayList<Pixel3D> LinePixels = line.getAllPixels(0.2f / line.getLength());
				for (int af = 0; af < LinePixels.size(); af++) {
					try {
						float progressY = (float) af / (float) LinePixels.size();
						float texY = ((progressY) * texHeight) + v;
						Color col = new Color(bimig.getRGB((int) texX, (int) texY));
						pixels.add(LinePixels.get(af).colorize(col));
					} catch (Exception err) {
					}
				}
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
