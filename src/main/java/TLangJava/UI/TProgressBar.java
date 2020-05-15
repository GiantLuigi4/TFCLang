package TLangJava.UI;

import TLangFunctional.Functional.Core.Class.Class;
import TLangFunctional.Functional.Utils.Interface.TLangExtendable;

import java.awt.*;

public class TProgressBar implements TLangExtendable {
    int posX;
    int posY;
    int max;
    int sizeX;
    int sizeY;
    Color fillColor;
    Color progressColor;
    int value = 0;

    public TProgressBar(int posX, int posY, int max, int sizeX, int sizeY, Color fillColor, Color progressColor) {
        this.posX = posX;
        this.posY = posY;
        this.max = max;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.fillColor = fillColor;
        this.progressColor = progressColor;
    }

    public void updateValue(int value) {
        this.value = value;
    }
    
    public Class clazz = null;
    
    @Override
    public Class getInstance() {
        return clazz;
    }
    
    @Override
    public Class setInstance(Class clazz) {
        this.clazz = clazz;
        return clazz;
    }
    
    public void Render(Graphics g) {
        try {
            TLangExtendable.execute("Render", new Object[]{g}, new String[]{"g"}, this);
        } catch (Exception err) {
            float var1 = (float) value;
            float var2 = (float) max;
            g.setColor(fillColor);
            g.fillRect(posX, posY, sizeX, sizeY);
            g.setColor(progressColor);
            g.fillRect(posX, posY, (int) (sizeX * (var1 / var2)), sizeY);
        }
    }
}
