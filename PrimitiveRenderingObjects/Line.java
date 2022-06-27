package PrimitiveRenderingObjects;

import java.awt.*;

public class Line implements Rendering.IDrawable{
    int x1,x2,y1,y2;
    Color color;
    float scale;
    public Line(Rendering.Point p1, Rendering.Point p2, Color color){
        this.x1 = p1.X;
        this.x2 = p2.X;
        this.y1 = p1.Y;
        this.y2 = p2.Y;
        this.color = color;
        this.scale = 1;
    }

    public void Draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.scale(scale,scale);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(20));
        g.drawLine(x1,y1,x2,y2);
    }
    public void UpdateScreenPosition(float x, float y) {
        x1 += x;
        x2 += x;
        y1 += y;
        y2 += y;
    }

}
