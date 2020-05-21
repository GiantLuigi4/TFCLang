package TLangJava.Display.ThreeDimensional;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Graphics3D {
    private int width = 1;
    private int height = 1;
    private int scaleX = 1;
    private int scaleY = 1;
    private float offX = 0;
    private float offY = 0;
    private float rotationX = 0;
    private float rotationY = 0;
    private Graphics thisGraphics;
	private static BufferedImage image;
    private ArrayList<Pixel3D> pixels = new ArrayList<>();
    private ArrayList<Rect3D> shapes = new ArrayList<>();
    private Pixel3D cam = new Pixel3D(0, 0, 0, 1, 1, 1, 1);
    private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    
    public void addPixel(Pixel3D pxl) {
        pixels.add(pxl);
    }
    
    public Graphics3D(Graphics g, int screenWidth, int screenHeight) {
        thisGraphics = g;
        image = new BufferedImage(screenWidth / 1, screenHeight / 1, BufferedImage.TYPE_INT_ARGB);
    }
    
    public void addLine(Line3D line) {
        pixels.addAll(line.getAllPixels(0.1f / line.getLength()));
    }
    
    public void Draw() {
        Draw(thisGraphics);
    }
    
    public void addShape(Rect3D rect) {
        shapes.add(rect);
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
    
    private void Draw(Graphics g) {
//        Main.TLangDebug.print(LogLevel.WARN,"pixels"+pixels.size());
        
        ((Graphics2D) g).setRenderingHints(hints);
        for (int i = 0; i < pixels.size(); i += 1) {
            pixels.set(i, pixels.get(i).rotateX(cam, rotationX));
//            pixels.set(i, Pixel3D.getPixelFromOffset(pixels.get(i), cam));
        }
        for (Rect3D rect : shapes) {
            rect.rotateX(cam, rotationX);
            rect.addToList(pixels);
//            pixels.addAll(rect.pixels);
        }
        ArrayList<Pixel3D> pixels = new ThreeDimensionalImage(this.pixels).getPixels();
        try {
            for (int i = 0; i < pixels.size(); i += draw(g, i)) ;
        } catch (Exception ignored) {
        }
//        ArrayList<Pixel3D> pixelsRounded=new ArrayList<>();
//        for (int i=0;i<pixels.size();i++) {
//            pixelsRounded.add(pixels.get(i).round());
//        }

//        int quality=4;
//        for (int x = 1; x< image.getWidth(); x+=quality) {
//            float xrot=((float)(x)/(float)image.getWidth())-0.5f;
//            for (int y = 1; y< image.getHeight(); y+=quality) {
//                float yrot=((float)(y)/(float)image.getHeight())-0.5f;
//                Pixel3D pxl=(RayTrace(
//                        new Pixel3D(yrot*-2,xrot*-2,-1,0,0,0,0),
//                        new Pixel3D(yrot*-16,xrot*-16,5,0,0,0,0),
//                        pixels,
//                        pixelsRounded
//                ));
//                try {
////                    Main.TLangDebug.print(LogLevel.WARN,""+x+","+y+","+pxl);
//                    Color col = new Color((int) (pxl.r * (cam.r / 255f)), (int) (pxl.g * (cam.g / 255f)), (int) (pxl.b * (cam.b / 255f)), pxl.a);
//                    image.setRGB(x+0,y+0,col.getRGB());
//                } catch (Exception err) {}
//            }
//        }

//        ((Graphics2D) g).translate(offX,offY);
//        ((Graphics2D) g).translate((-image.getWidth()/2)*scaleX,(-image.getHeight()/2)*scaleY);
//        ((Graphics2D) g).scale(scaleX,scaleY);
//        ((Graphics2D) g).setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON));
//        g.drawImage(image.getScaledInstance(image.getWidth()*scaleX,image.getHeight()*scaleY,BufferedImage.SCALE_AREA_AVERAGING),0,0,null);
        g.drawImage(image, 0, 0, image.getWidth() * 1, image.getHeight() * 1, null);
    }
    
    public void setRenderingHints(RenderingHints hints) {
        this.hints = hints;
    }
    
    public void rotateX(float rotationX) {
        this.rotationX = rotationX;
    }
    
    public void translate(float offX, float offY) {
        this.offX = offX * scaleX;
        this.offY = offY * scaleY;
    }

    public void setCam(float x, float y, float z) {
        this.cam = new Pixel3D(x, y, z, 1, 1, 1, 1);
    }
    
    public void setCam(float x, float y, float z, float r, float g, float b, float a) {
        this.cam = new Pixel3D(x, y, z, (int) (r * 255), (int) (g * 255), (int) (b * 255), (int) (a * 255));
    }
    
    private int drawOne(Graphics g, int i) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(hints);
        try {
//            Pixel3D drawing=pixels.get(i);
//            Pixel3D drawing=pixels.get(i).rotateY(new Pixel3D(0,0,0,0,0,0,0),0);
//            drawing=new Pixel3D((int)(drawing.x*4)/4f,(int)(drawing.y*4)/4f,(int)drawing.z,drawing.r,drawing.g,drawing.b,drawing.a);
            Pixel3D drawing = Pixel3D.getPixelFromOffset(pixels.get(i), cam);
            if (drawing.z > 0) {
                drawing = Pixel3D.getPixelFromOffset(drawing, cam);
//                for (int x=0;x<=image.getWidth();x++) {
//                    float xrot=((float)x/(float)image.getWidth())-0.5f;
//                    for (int y=0;y<=image.getWidth();y++) {
//                        float yrot=((float)y/(float)image.getHeight())-0.5f;
//                        if (RayTrace(
//                                new Pixel3D(0,0,0,0,0,0,0),
//                                new Pixel3D(xrot,yrot,60,0,0,0,0),
//                                drawing
//                        )) {
//                            Color col = new Color((int) (drawing.r * (cam.r / 255f)), (int) (drawing.g * (cam.g / 255f)), (int) (drawing.b * (cam.b / 255f)), drawing.a);
//                            image.setRGB(x,y,col.getRGB());
//                        }
//                    }
//                }
//                g.setColor(new Color(drawing.r, drawing.g, drawing.b, drawing.a));
//                AffineTransform oldTransform = g2d.getTransform();
//                g2d.translate(offX, offY);
////                float y=rotationX;
////                float negativeY = 1;
////                if (("" + y).startsWith("-")) {
////                    negativeY = -1;
////                }
//                g2d.translate((drawing.x * scaleX), ((-drawing.y) * scaleY));
//                g2d.translate(-(width / 2), -(height / 2));
//                try {
//                    Pixel3D next = Pixel3D.getPixelFromOffset(pixels.get(i + 1), cam);
//                    if (new Line3D(drawing, next).getLength() <= 2) {
//                        ((Graphics2D) g).setStroke(new BasicStroke(width * 3));
//                        g.drawLine(0, 0, (int) Math.ceil(next.x - drawing.x), (int) Math.ceil(next.y - drawing.y));
//                        g.fillRect(-2, -2, (int)(2 * scaleX), (int)(1 * scaleY));
//                    } else {
//                        g.fillRect(0, 0, width, height);
//                    }
////                    image.setRGB((int)(drawing.x), (int)((-drawing.y)),new Color(drawing.r,drawing.g,drawing.b,drawing.a).getRGB());
//                } catch (Exception err) {
//                    g.fillRect(0, 0, width, height);
//                }
//                g2d.setTransform(oldTransform);
    
                /**currentKnownWorking*/
                Color col = new Color((int) (drawing.r * (cam.r / 255f)), (int) (drawing.g * (cam.g / 255f)), (int) (drawing.b * (cam.b / 255f)), drawing.a);
                Graphics img = image.getGraphics();
                img.setColor(col);
                img.fillRect(
                        (int) (drawing.x * scaleX + offX),
                        (int) (-(drawing.y * scaleY) + offY),
                        (scaleX * width),
                        (scaleY * height));


//                for (int aflackX=0;aflackX<(scaleX*width);aflackX+=1) {
//                    for (int aflackY=0;aflackY<(scaleY*height);aflackY+=1) {
//                        try {
//                            image.setRGB((int)(drawing.x*scaleX+offX+aflackX), (int)(-(drawing.y*scaleY)+offY+(aflackY)),col.getRGB());
//                        } catch (Exception err) {}
//                    }
//                }

//                for (int aflackX=0;aflackX<width;aflackX++) {
//                    for (int aflackY=0;aflackY<height;aflackY++) {
//                        image.setRGB((int)(drawing.x+(image.getWidth()/2)+aflackX), (int)(-(drawing.y)+aflackY+(image.getHeight()/2)),new Color(drawing.r,drawing.g,drawing.b,drawing.a).getRGB());
//                    }
//                }
            }
            return 1;
        } catch (ArithmeticException err) {
            return 1;
        }
    }
    
    public Pixel3D RayTrace(Pixel3D start, Pixel3D end, ArrayList<Pixel3D> target, ArrayList<Pixel3D> targetRounded) {
        Line3D tracer = new Line3D(start, end);
        for (Pixel3D pxl : tracer.getAllPixels(1)) {
            if (pxl.z >= 1) {
                if (targetRounded.contains(pxl.round())) {
//                    if (target.get(targetRounded.indexOf(pxl.round())).x!=cam.x) {
//                        if (target.get(targetRounded.indexOf(pxl.round())).y!=cam.y) {
//                            if (target.get(targetRounded.indexOf(pxl.round())).z!=cam.z) {
                    return target.get(targetRounded.indexOf(pxl.round()));
//                            }
//                        }
//                    }
                }
            }
        }
        return new Pixel3D(0, 0, 0, 0, 0, 0, 0);
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
