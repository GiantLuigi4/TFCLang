package Editor;

import TLangJava.Display.ThreeDimensional.Graphics3D;
import TLangJava.Display.ThreeDimensional.Line3D;
import TLangJava.Display.ThreeDimensional.Pixel3D;
import TLangJava.Display.ThreeDimensional.Rect3D;

import javax.swing.*;
import java.awt.*;

public class ThreeDDisplayTest extends JComponent {
	float z = 0;
	float cx = 0;
	static JFrame frame = new JFrame();

	public static void main(String[] args) {
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
		g.setColor(new Color(0));
		g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		Graphics3D G3D = new Graphics3D(g);
		G3D.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
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
		G3D.addRect(new Rect3D(
				new Line3D(
						new Pixel3D(10, 0, 0, 0, 0, 255, 255),
						new Pixel3D(-10, 0, 0, 0, 0, 255, 255)
				),
				new Line3D(
						new Pixel3D(10, 0, 10, 255, 0, 255, 255),
						new Pixel3D(-10, 0, 10, 255, 0, 255, 255)
				)
		));
		G3D.addRect(new Rect3D(
				new Line3D(
						new Pixel3D(10, 0, -10, 0, 0, 255, 255),
						new Pixel3D(-10, 0, -10, 0, 0, 255, 255)
				),
				new Line3D(
						new Pixel3D(10, 0, 0, 255, 0, 255, 255),
						new Pixel3D(-10, 0, 0, 255, 0, 255, 255)
				)
		));
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
		z += 0.01;
		cx += 0;
		G3D.translate(frame.getWidth() / 8, frame.getHeight() / 4);
		G3D.setSize(4, 4);
//		G3D.setCam((float) (Math.cos(cx) * 5), 0, 0);
		G3D.setCam(0, 0, 0);
//		G3D.rotateX(90);
//		G3D.rotateX((float) Math.cos(z) + 180);
		G3D.rotateX(z);
		G3D.setLineSize(2, 1);
		G3D.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		G3D.Draw();
		super.paint(g);
	}
}
