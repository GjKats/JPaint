package model.shapes;

import java.awt.*;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeStrategy;
import model.ShapeType;
import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;

class Ellipse implements IShape {

    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;
    private Point startPoint;
	private Point endPoint;
    private int x;
    private int y;
    private int width;
    private int height;
    private IShapeStrategy strategy;
    private boolean isSelected;


    Ellipse() {
        shapeType = ShapeType.ELLIPSE;
        primaryColor = null;
        secondaryColor = null;
        shadingType = null;
        startPoint = new Point(0,0);
        endPoint = new Point(0,0);
        strategy = new ShapeStrategy(this);
        isSelected = false;
    }

    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }

    @Override
    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    @Override
    public void setPrimaryColor(ShapeColor primaryColor) {
        this.primaryColor = primaryColor;
    }

    @Override
    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    @Override
    public void setSecondaryColor(ShapeColor secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    @Override
    public ShapeShadingType getShadingType() {
        return shadingType;
    }

    @Override
    public void setShadingType(ShapeShadingType shadingType) {
        this.shadingType = shadingType;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        strategy.draw(graphics2D);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setX(int x) {
         this.x = x;
    }
    
    public void setY(int y) {
    	this.x = y;
    }
    
    public void setWidth(int width) {
    	this.x = width;
    }
    
    public void setHeight(int height) {
    	this.x = height;
    }

	@Override
	public model.Point getStartPoint() {
		return startPoint;
	}

	@Override
	public model.Point getEndPoint() {
		return endPoint;
		
	}

	@Override
	public void setStartPoint(model.Point startPoint) {
		this.startPoint = startPoint;
		
	}

	@Override
	public void setEndPoint(model.Point endPoint) {
		this.endPoint = endPoint;
		
	}

    @Override
    public void select() { 
    	isSelected = true; 
    }

    @Override
    public void unSelect() { 
    	isSelected = false; 
    }

    @Override
    public boolean isSelected() { 
    	return isSelected; 
    }
    

}
