package Rendering;

public class Point {

    public static Point P_ZERO = new Point(0,0);
    public static Point P_UP = new Point(0,1);
    public static Point P_DOWN = new Point(0,-1);
    public static Point P_LEFT = new Point(-1,0);
    public static Point P_RIGHT = new Point(1,0);

    public int X;
    public int Y;
    public Point(int x, int y){
        X=x;
        Y=y;
    }

    public static Point mult(Point p, Point mult){
        p.X*=mult.X;
        p.Y*=mult.Y;
        return p;

    }
}
