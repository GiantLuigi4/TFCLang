package TLangJava.Display.ThreeDimensional;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Graphics3D {
    private ArrayList<Pixel3D> pixels = new ArrayList<>();
    private Graphics thisGraphics;
    private int width = 1;
    private int height = 1;
    private int scaleX = 4;
    private int scaleY = 4;
    private int offX = 0;
    private int offY = 0;
    private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    private float rotationX = 0;
    private Pixel3D cam = new Pixel3D(0, 0, 0, 0, 0, 0, 0);
    
    public Graphics3D(Graphics g) {
        thisGraphics = g;
    }
    
    public void addPixel(Pixel3D pxl) {
        pixels.add(pxl);
    }
    
    public void addLine(Line3D line) {
        pixels.addAll(line.getAllPixels(0.25f / line.getLength()));
    }
    
    public void addRect(Rect3D rect) {
        rect.prep();
        pixels.addAll(rect.image.getPixels());
    }
    
    public void Draw() {
        Draw(thisGraphics);
    }
    
    private void Draw(Graphics g) {
//        Main.TLangDebug.print(LogLevel.WARN,"pixels"+pixels.size());
    
        ((Graphics2D) g).setRenderingHints(hints);
        for (int i = 0; i < pixels.size(); i += 1) {
            pixels.set(i, Pixel3D.getPixelFromOffset(pixels.get(i).rotateX(cam, rotationX), cam).offset(cam));
//            pixels.set(i, Pixel3D.getPixelFromOffset(pixels.get(i), cam));
        }
        ArrayList<Pixel3D> pixels = new ThreeDimensionalImage(this.pixels).getPixels();
        try {
            for (int i = 0; i < pixels.size(); i += draw(g, i)) ;
        } catch (Exception ignored) {
        }
    }
    
    private int draw(Graphics g, int i) {
        int x = 0;
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        x += drawOne(g, i + x);
        return x;
    }
    
    public void setLineWidth(int width) {
        this.width = width;
    }
    
    public void setLineHeight(int height) {
        this.height = height;
    }
    
    public void setLineSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void setSize(int width, int height) {
        this.scaleX = width;
        this.scaleY = height;
    }
    
    public void translate(int offX, int offY) {
        this.offX = offX * scaleX;
        this.offY = offY * scaleY;
    }
    
    public void setRenderingHints(RenderingHints hints) {
        this.hints = hints;
    }
    
    public void rotateX(float rotationX) {
        this.rotationX = rotationX;
    }
    
    public void setCam(float x, float y, float z) {
        this.cam = new Pixel3D(x, y, z, 0, 0, 0, 0);
    }
    
    private int drawOne(Graphics g, int i) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(hints);
        try {
            Pixel3D drawing = Pixel3D.getPixelFromOffset(pixels.get(i), cam);
            if (drawing.z > 3) {
                g.setColor(new Color(drawing.r, drawing.g, drawing.b, drawing.a));
                AffineTransform oldTransform = g2d.getTransform();
                g2d.translate(offX, offY);
//                float y=rotationX;
//                float negativeY = 1;
//                if (("" + y).startsWith("-")) {
//                    negativeY = -1;
//                }
                g2d.translate((drawing.x * scaleX), ((-drawing.y) * scaleY));
                g2d.translate(-(width / 2), -(height / 2));
                try {
                    Pixel3D next = Pixel3D.getPixelFromOffset(pixels.get(i + 1), cam);
                    if (new Line3D(drawing, next).getLength() <= 2) {
                        ((Graphics2D) g).setStroke(new BasicStroke(width * 1.3f));
                        g.drawLine(0, 0, (int) Math.ceil(next.x - drawing.x), (int) Math.ceil(next.y - drawing.y));
                        g.fillRect(0, -2, 3 * scaleX, 3 * scaleY);
                    } else {
                        g.fillRect(0, 0, width, height);
                    }
                } catch (Exception err) {
                    g.fillRect(0, 0, width, height);
                }
                g2d.setTransform(oldTransform);
            }
            return 1;
        } catch (ArithmeticException err) {
            return 1;
        }
    }

//    public Pixel3D RayTrace(int dist, Pixel3D target) {
//        for (float i=-1;i<=1;i+=0.1f) {
//            try { return TraceRow(dist,target,i); } catch (Exception err) {}
//        }
//        throw new RuntimeException();
//    }
//    public Pixel3D TraceRow(int dist, Pixel3D target,float angleY) {
//        for (float i=-1;i<=1;i+=0.1f) {
//            try { return TraceRay(dist,target,i,angleY); } catch (Exception err) {}
//        }
//        throw new RuntimeException();
//    }
//    public Pixel3D TraceRay(int dist, Pixel3D target,float angleX,float angleY) {
//        try {
//            for (int i=1;i<=dist;i++) {
//                try {
//                    return testPoint(target,i,Math.floor(angleX*(i)),Math.floor(angleY*(i)));
//                } catch (Exception ignored) {}
//            }
//        } catch (Exception ignored) {}
//        throw new RuntimeException();
//    }
//    public Pixel3D testPoint(Pixel3D target,int z,double x,double y) {
//        if (target.z<=z) {
//            if (Math.floor(target.x)==x) {
//                if (Math.floor(target.y)==y) {
//                    return target;
//                }
//            }
//        }
//        throw new RuntimeException();
//    }
}
