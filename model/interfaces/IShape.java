package model.interfaces;

import model.ShapeType;
import java.awt.Graphics2D;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;

public interface IShape {
	ShapeType getShapeType();
    ShapeColor getPrimaryColor();
    void setPrimaryColor(ShapeColor primaryColor);
    ShapeColor getSecondaryColor();
    void setSecondaryColor(ShapeColor secondaryColor);
    ShapeShadingType getShadingType();
    void setShadingType(ShapeShadingType shadingType);
    Point getStartPoint();
    Point getEndPoint();
    void setStartPoint(Point startPoint);
    void setEndPoint(Point endPoint);
    void draw(Graphics2D graphics2D);
    void select();
    void unSelect();
    boolean isSelected();
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void setX(int x);
    void setY(int y);
    void setWidth(int width);
    void setHeight(int height);
}
