package model;

import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class ShapeStrategy implements IShapeStrategy {

    private IShape shape;

    public ShapeStrategy(IShape shape) {
        this.shape = shape;
    }

    private Color getColor(ShapeColor color) {
    	return ColorMapping.getColor(color);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
    	Shape createdShape = null;
        int startX = shape.getStartPoint().getX();
        int startY = shape.getStartPoint().getY();
        int endX = shape.getEndPoint().getX();
        int endY = shape.getEndPoint().getY();
        int width = endX - startX;
        int height = endY - startY;
        Color primary = getColor(shape.getPrimaryColor());
        Color secondary = getColor(shape.getSecondaryColor());
       
        if(shape.getShapeType() == shape.getShapeType().RECTANGLE) {
        	createdShape = new Rectangle(startX, startY, width, height);
        }
        
        else if(shape.getShapeType() == shape.getShapeType().ELLIPSE) {
        	createdShape = new Ellipse2D.Double(startX, startY, width, height);
        }

        else if(shape.getShapeType() == shape.getShapeType().TRIANGLE) {
        	int[] xDimensions = {startX, startX, endX};
        	int[] yDimensions = {startY, endY, endY};
        	createdShape = new Polygon(xDimensions, yDimensions, 3);
        }
        
        if(shape.getShadingType() == shape.getShadingType().OUTLINE) {
          graphics2D.setColor(primary);
          graphics2D.draw(createdShape);
        }
        else if(shape.getShadingType() == shape.getShadingType().FILLED_IN) {
          graphics2D.setColor(primary);
          graphics2D.fill(createdShape);
        }
        else if(shape.getShadingType() == shape.getShadingType().OUTLINE_AND_FILLED_IN) {
          graphics2D.setColor(secondary);
          graphics2D.fill(createdShape);
          graphics2D.setColor(primary);
          graphics2D.draw(createdShape);
          
        }

        if(shape.isSelected()) {
            graphics2D.setColor(Color.BLACK);
            Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            graphics2D.setStroke(dashed);
            graphics2D.draw(new RoundRectangle2D.Double(startX, startY, width, height, 10, 10));
        }
        graphics2D.dispose();
    }
    
}
