package model.shapes;

import model.Point;
import model.interfaces.IShape;

public class ShapeFactory {
    public static IShape createShape(String shapeType) {
        IShape shape = null;
        shapeType = shapeType.toLowerCase();
        
        switch(shapeType) {
            case "triangle":
                shape = new Triangle();
                break;
            case "rectangle":
                shape = new Rectangle();
                break;
            case "ellipse":
                shape = new Ellipse();
                break;
            default:
                break;
        }
        return shape;
    }

    public static IShape copyShape(IShape shape) {
        IShape newShape = null;
        
        if(shape.getShapeType() == shape.getShapeType().RECTANGLE) {
        	newShape = new Rectangle();
        }
        else if(shape.getShapeType() == shape.getShapeType().ELLIPSE) {
        	newShape = new Ellipse();
        }
        else if(shape.getShapeType() == shape.getShapeType().TRIANGLE) {
        	newShape = new Triangle();
        }

        int startX = shape.getStartPoint().getX();
        int startY = shape.getStartPoint().getY();
        int endX = shape.getEndPoint().getX();
        int endY = shape.getEndPoint().getY();
        newShape.setStartPoint(new Point(startX, startY));
        newShape.setEndPoint(new Point(endX, endY));
        newShape.setPrimaryColor(shape.getPrimaryColor());
        newShape.setSecondaryColor(shape.getSecondaryColor());
        newShape.setShadingType(shape.getShadingType());
        return newShape;
    }
}
