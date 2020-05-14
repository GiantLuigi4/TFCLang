package Editor;

import TLangJava.Display.ThreeDimensional.*;
import TLangJava.Math.Trig;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ThreeDDisplayTest extends JComponent {
	float z = 0;
	float cx = 0;
	static JFrame frame = new JFrame();

	public static void main(String[] args) {
		Trig.prepMemoryCos(0.01f);
		Trig.prepMemorySin(0.01f);
		ThreeDDisplayTest displayTest = new ThreeDDisplayTest();
		frame.add(displayTest);
		frame.setSize(300, 300);
		frame.setVisible(true);
		while (true) {
			displayTest.repaint();
			try {
				Thread.sleep(1);
			} catch (Exception err) {
			}
		}
	}
	
	@Override
	public boolean isOptimizedDrawingEnabled() {
		return true;
	}
	
	@Override
	public void paint(Graphics g) {
		BufferedImage test = new BufferedImage(8, 8, BufferedImage.TYPE_INT_ARGB);
//		Graphics2D g2d=(Graphics2D)test.getGraphics();
		try {
			test = ImageIO.read(new File(Main.projectsDir + "\\test.png"));
		} catch (Exception err) {
		}
		g.setColor(new Color(0));
		g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		Graphics3D G3D = new Graphics3D(g, frame.getWidth(), frame.getHeight());
//		G3D.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		G3D.addRect(new Rect3D(
				new Line3D(
						new Pixel3D(-10, 0, 10, 255, 0, 0, 255),
						new Pixel3D(10, 0, 10, 255, 0, 0, 255)
				),
				new Line3D(
						new Pixel3D(-10, 15, 10, 0, 255, 0, 255),
						new Pixel3D(10, 15, 10, 0, 255, 0, 255)
				)
		));
		G3D.addRect(new Rect3D(
				new Line3D(
						new Pixel3D(10, 0, -10, 255, 255, 0, 255),
						new Pixel3D(-10, 0, -10, 255, 255, 0, 255)
				),
				new Line3D(
						new Pixel3D(10, 15, -10, 0, 255, 255, 255),
						new Pixel3D(-10, 15, -10, 0, 255, 255, 255)
				)
		));
		G3D.addRect(new TexturedRect3D(
				new Line3D(
						new Pixel3D(10, 0, -10, 0, 0, 255, 255),
						new Pixel3D(-10, 0, -10, 0, 0, 255, 255)
				),
				new Line3D(
						new Pixel3D(10, 0, 10, 255, 0, 255, 255),
						new Pixel3D(-10, 0, 10, 255, 0, 255, 255)
				), test, 0, 0, test.getWidth(), test.getHeight()
		));
//		for (int h=0;h<16;h++) {
//			for (int i=0;i<16;i++) {
//				try {
//					test.setRGB(h,i,new Color((16-i)*12,h*12,i*12).getRGB());
//				} catch (Exception err) {}
//			}
//		}
//		G3D.addRect(new TexturedRect3D(
//				new Line3D(
//						new Pixel3D(10, 0, -10, 0, 0, 255, 255),
//						new Pixel3D(-10, 0, -10, 0, 0, 255, 255)
//				),
//				new Line3D(
//						new Pixel3D(10, 0, 0, 255, 0, 255, 255),
//						new Pixel3D(-10, 0, 0, 255, 0, 255, 255)
//				),test,0,0,test.getWidth(),test.getHeight()
//		));
//		for (float y = 0; y <= 10; y += 0.1f) {
//			G3D.addLine(new Line3D(
//					new Pixel3D(-10, y, 0, 0, (int) (y * 25.5f), 0, 255),
//					new Pixel3D(-10, y, 20, 20, (int) (255 - (y * 25.5f)), 0, 255)
//			));
//		}
//		for (float y = 0; y <= 10; y += 0.1f) {
//			G3D.addLine(new Line3D(
//					new Pixel3D(10, y, 0, (int) (y * 25.5f), 0, 0, 255),
//					new Pixel3D(10, y, 20, (int) (255 - (y * 25.5f)), 0, 0, 255)
//			));
//		}
//		for (float y = 0; y <= 10; y += 0.1f) {
//			G3D.addLine(new Line3D(
//					new Pixel3D(10, y, 0, (int) (y * 25.5f), 0, 0, 255),
//					new Pixel3D(20, y, 0, 0, 0, (int) (255 - (y * 25.5f)), 255)
//			));
//		}
//		for (float y = 0; y <= 10; y += 0.1f) {
//			G3D.addLine(new Line3D(
//					new Pixel3D(-10, y, 0, 0, (int) (y * 25.5f), 0, 255),
//					new Pixel3D(-20, y, 0, 0, 0, (int) (255 - (y * 25.5f)), 255)
//			));
//		}
		z += 1;
		cx += 0;
		G3D.translate(frame.getWidth() / 8, frame.getHeight() / 4 + 8);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		float f = (float) frame.getWidth() / (float) d.getWidth();
		G3D.setSize((int) (f * 16), (int) (f * 16));
		if ((int) (f * 16) == 0) {
			G3D.setSize(1, 1);
		}
//		G3D.setCam((float) (Math.cos(cx) * 50), 0, 0);
		G3D.setCam(0, 0, 0, 1, 1, 1, 1);
//		G3D.rotateX((float)Math.toRadians(-90));
//		G3D.rotateX((float) Math.cos(z) + 180);
//		G3D.rotateX((float)Math.toRadians(z));
		G3D.rotateX((float) (Trig.sin(z / 100, true)));
		G3D.setLineSize(1, 1);
//		G3D.setRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED));
		G3D.Draw();
		super.paint(g);
	}
}
