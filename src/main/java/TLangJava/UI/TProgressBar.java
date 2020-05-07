package TLangJava.UI;

import java.awt.*;

public class TProgressBar {
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

    public void Render(Graphics g) {
        float var1 = (float) value;
        float var2 = (float) max;
        g.setColor(fillColor);
        g.fillRect(posX, posY, sizeX, sizeY);
        g.setColor(progressColor);
        g.fillRect(posX, posY, (int) (sizeX * (var1 / var2)), sizeY);
    }
}
