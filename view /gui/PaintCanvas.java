package view.gui;

import model.ShapeList;
import model.interfaces.IObserver;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;
import java.awt.*;

public class PaintCanvas extends PaintCanvasBase implements IObserver {

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    @Override
    public void update() {
        Graphics2D g = getGraphics2D();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        for(IShape shape : ShapeList.getInstance().getShapes()) {
            shape.draw(getGraphics2D());
        }
    }
}
