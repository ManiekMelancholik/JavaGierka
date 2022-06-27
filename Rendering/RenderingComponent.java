package Rendering;

import Main.MouseActions.IMouseDelegate;
import Main.MouseActions.ISearchable;
import PrimitiveRenderingObjects.Hexagon;

import java.awt.*;
import java.util.ArrayList;

public class RenderingComponent implements IDrawable, ISearchable {

    public ArrayList<Hexagon> collection;

    public RenderingComponent() {
        collection = new ArrayList<>();
    }

    @Override
    public void Draw(Graphics g) {
        for (IDrawable IDR : collection) IDR.Draw(g);
    }

    public void UpdateScreenPosition(float x, float y) {
        for (IDrawable IDO : collection) IDO.UpdateScreenPosition(x, y);
    }

    public void Add(Hexagon object) {
        collection.add(object);
    }
    public void Reg(){
        for (IDrawable IDO : collection) IDO.Reg();
    }
    public void search(Point p){
        for (Hexagon hex: collection) {
            hex.check(p);
        }
    }

    @Override
    public void Scale(float newSize) {
        for (IDrawable IDO : collection) IDO.Scale(newSize);
    }

    @Override
    public void search(Point p, IMouseDelegate action) {
        for (ISearchable IS: collection) {
            IS.search(p, action);
        }
    }
}
