package Editor;

import TLangJava.Display.ThreeDimensional.Graphics3D;
import TLangJava.Display.ThreeDimensional.Line3D;
import TLangJava.Display.ThreeDimensional.Pixel3D;
import TLangJava.Display.ThreeDimensional.TexturedRect3D;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class TerrainGenTest extends JComponent {
	static JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		TerrainGenTest disp = new TerrainGenTest();
		frame.add(disp);
		while (frame.isVisible()) {
			disp.repaint();
		}
		Runtime.getRuntime().exit(0);
	}
	
	@Override
	public void paint(Graphics g) {
		BufferedImage test = new BufferedImage(8, 8, BufferedImage.TYPE_INT_ARGB);
		try {
			test = ImageIO.read(new File(Main.projectsDir + "\\test.png"));
		} catch (Exception err) {
		}
		g.setColor(new Color(0));
		g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		Graphics3D g3D = new Graphics3D(g, frame.getWidth(), frame.getHeight());
		g3D.translate(frame.getWidth() / 8, frame.getHeight() / 4 + 8);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		float f = (float) frame.getWidth() / (float) d.getWidth();
		g3D.setSize((int) (f * 16), (int) (f * 16));
		if ((int) (f * 16) == 0) {
			g3D.setSize(1, 1);
		}
		
		g3D.addShape(new TexturedRect3D(
				new Line3D(new Pixel3D(0, 0, 0, 0, 0, 0, 0), new Pixel3D(0, 0, 10, 0, 0, 0, 0)),
				new Line3D(new Pixel3D(0, 0, 0, 0, 0, 0, 0), new Pixel3D(10, 0, 0, 0, 0, 0, 0)),
				test,
				0,
				0,
				test.getWidth(),
				test.getHeight()
		));
		g3D.setCam(0, 0, 0, 1, 1, 1, 1);
		g3D.setLineSize(2, 1);
		g3D.Draw();
		super.paint(g);
	}
	
	private class Vertex {
		public int x;
		public int y;
		public int z;
		
		public Vertex(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	private class Triangle3D extends TexturedRect3D {
		
		public Triangle3D(Vertex v1, Vertex v2, Vertex v3, BufferedImage texture) {
			super(
					new Line3D(new Pixel3D(v1.x, v1.y, v1.z, 0, 0, 0, 0), new Pixel3D(v2.x, v2.y, v2.z, 0, 0, 0, 0)),
					new Line3D(new Pixel3D(v1.x, v1.y, v1.z, 0, 0, 0, 0), new Pixel3D(v3.x, v3.y, v3.z, 0, 0, 0, 0)),
					texture, 0, 0, texture.getWidth(), texture.getHeight()
			);
		}
		
		public Triangle3D(Line3D line1, Line3D line2, BufferedImage bimig, int u, int v, int texWidth, int texHeight) {
			super(line1, line2, bimig, u, v, texWidth, texHeight);
		}
	}
}
