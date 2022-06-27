package PrimitiveRenderingObjects;

import java.awt.*;

public class Triangle implements Rendering.IDrawable{
    int[] xPoints;
    int[] yPoints;

    Color color;

    float scale;
    public Triangle(Rendering.Point p1, Rendering.Point p2, Rendering.Point p3, Color color){

        xPoints = new int[3];
        yPoints = new int[3];


        xPoints[0] = p1.X;
        xPoints[1] = p2.X;
        xPoints[2] = p3.X;

        yPoints[0] = p1.Y;
        yPoints[1] = p2.Y;
        yPoints[2] = p3.Y;

        this.color = color;
        scale = 1;
    }

    public void Draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(color);
        g2d.scale(scale,scale);
        g2d.fillPolygon(xPoints,yPoints,xPoints.length);

    }
    public void UpdateScreenPosition(float x, float y){
        xPoints[0] += x;
        xPoints[1] += x;
        xPoints[2] += x;

        yPoints[0] += y;
        yPoints[1] += y;
        yPoints[2] += y;
    }

}
