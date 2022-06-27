package PrimitiveRenderingObjects;

import Main.GameWorld.GameObject;
import Main.GameWorld.IWorldComponent;
import Main.MainWindow.Zoom;
import Main.MouseActions.IMouseDelegate;
import Main.MouseActions.ISearchable;
import Rendering.IDrawable;
import Rendering.Point;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;


public class Hexagon implements Rendering.IDrawable, ISearchable {
    Rendering.Point center;
    int xCenterPreResize;
    int yCenterPreResize;
    int size;
    int startingSize;

    int[] xPoints;
    int[] yPoints;
    public IWorldComponent parent;
    public Color color;
    Color strokeColor;
    BasicStroke stroke;
    Color standardColor = Color.GRAY;
    BasicStroke standardStroke = new BasicStroke(4);
    Color selectedBorderColor = Color.getHSBColor(360F / 216.08F, 0.6F, 1F);
    BasicStroke selectedStroke = new BasicStroke(4);

    BufferedImage texture;

    public static float offset = 1F;
    public static int DEF_SIZE;

    public void setTexture(BufferedImage img, int height){
//        texture = new TexturePaint(img,
//                new Rectangle2D.Double(0,0 ,img.getWidth(),img.getHeight()));
       //standardStroke = new BasicStroke(height);
       //selectedStroke = new BasicStroke(height);
        texture = img;
        // texture = new TexturePaint(img,new Polygon(xPoints,yPoints,6))
    }

    public Hexagon(Rendering.Point center, int size1, Color color, IWorldComponent parent) {

        this.size = size1 * 10;
        this.startingSize = size;
        this.center = center;
        xCenterPreResize = center.X;
        yCenterPreResize = center.Y;
        DEF_SIZE = size;

        xPoints = new int[6];
        yPoints = new int[6];


        int halfSize = size / 2;
        int h = (size * 17) / 20;

        xPoints[0] = center.X;
        xPoints[1] = center.X + h;
        xPoints[2] = center.X + h;

        xPoints[3] = center.X;
        xPoints[4] = center.X - h;
        xPoints[5] = center.X - h;

        yPoints[0] = center.Y + size;
        yPoints[1] = center.Y + halfSize;
        yPoints[2] = center.Y - halfSize;

        yPoints[3] = center.Y - size;
        yPoints[4] = center.Y - halfSize;
        yPoints[5] = center.Y + halfSize;
        this.color = color;
        this.parent = parent;
        this.strokeColor = color;
        this.stroke = standardStroke;
        //this.setTexture();
    }

    public void Draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        //g2d.setPaint(TexturesHolder.get_instance().TEXTURE_gras);
        //g2d.setClip(new GeneralPath());
        TexturePaint text = new TexturePaint(texture,
                new Rectangle2D.Double(center.X-size,center.Y-size ,texture.getWidth()*size/60,texture.getHeight()*size/60));
        ((Graphics2D) g).setPaint(text);
        g2d.fillPolygon(xPoints, yPoints, 6);
//        g2d.setColor(strokeColor);
        g2d.setColor(color);
        g2d.setStroke(stroke);
        //g2d.setColor(Color.gray);
        //g2d.setStroke(new BasicStroke(2));
        g2d.drawPolygon(xPoints, yPoints, 6);
        GameObject u = parent.getGameObject();
        if(u != null){
            g2d.setColor(u.player.c);
            g2d.setStroke(stroke);
            //g2d.setColor(Color.gray);
            //g2d.setStroke(new BasicStroke(2));
            int[] ix = {xPoints[0],xPoints[2],xPoints[4]};
            int[] iy = {yPoints[0],yPoints[2],yPoints[4]};
            g2d.drawPolygon(ix, iy, 3);

            //g2d.scale((float)startingSize/(float) size,(float)startingSize/(float) size);
           // g2d.drawImage(u.Display(),null,center.X-size,center.Y-size);
            AffineTransform old = g2d.getTransform();

            text = new TexturePaint(u.display(GameObject._IDLE), new Rectangle2D.Double(center.X-size,center.Y-size,size*2,size*2));
            g2d.setPaint(text);
            g2d.rotate(u.getAngle(),center.X,center.Y);
            g2d.fillRect(center.X-size,center.Y-size,size*2,size*2);
            g2d.setTransform(old);

        }

    }

    public void UpdateScreenPosition(float x, float y) {
        for (int i = 0; i < yPoints.length; i++) {
            yPoints[i] += y;
            xPoints[i] += x;
        }
        center.X += x;
        center.Y += y;
        xCenterPreResize += x;
        yCenterPreResize += y;
        //System.out.println(center.X+"::::"+ center.Y);

    }

    public void Reg() {
        //System.out.println(center.X+" : "+ center.Y);
    }

    static final int a = 3;
    static final int b = 4;

    public boolean check(Point p) {
        // = 1+10*Zoom.currentZoom;
        if (p.X < center.X + ((size + offset) * a) / b && p.X > center.X - ((size - offset) * a) / b)
            if (p.Y < center.Y + ((size + offset) * a) / b && p.Y > center.Y - ((size - offset) * a) / b) {
//                this.stroke = selectedStroke;
//                this.strokeColor = selectedBorderColor;
//                this.parent.setUnit(new Unit(TexturesHolder._instance.TEXTURE_meh_idle));
//                this.parent.changeConnected();
                //((IConnectable)parent).highlightConnected(2);
                return true;
            }
        return false;
    }

    @Override
    public void Scale(float newSize) {



        float scale = 1;
//        if (newSize > 0)
//            scale = 0.5F;
//        if (newSize < 0)
//            scale = 2;

        this.size =(int) ((float)startingSize *newSize);
        center.X = (int)((float)xCenterPreResize*newSize);
        center.Y = (int)((float)yCenterPreResize*newSize);
        int halfSize = size / 2;
        int h = (size * 17) / 20;

        xPoints[0] = center.X;
        xPoints[1] = center.X + h;
        xPoints[2] = center.X + h;

        xPoints[3] = center.X;
        xPoints[4] = center.X - h;
        xPoints[5] = center.X - h;

        yPoints[0] = center.Y + size;
        yPoints[1] = center.Y + halfSize;
        yPoints[2] = center.Y - halfSize;

        yPoints[3] = center.Y - size;
        yPoints[4] = center.Y - halfSize;
        yPoints[5] = center.Y + halfSize;
    }

    @Override
    public void search(Point p, IMouseDelegate action) {
        if(this.check(p))action.action(this);
    }

    @Override
    public IDrawable copy() {

        Hexagon hex = new Hexagon(new Point(xCenterPreResize,yCenterPreResize),this.startingSize/10,this.color,this.parent);
        hex.texture = this.texture;
        //hex.Scale(4f);
        //System.out.println("AAAAA");
        hex.Scale(Zoom.ZOOM_LEVELS[Zoom.zoomIndexer]);
        return hex;

    }
}
