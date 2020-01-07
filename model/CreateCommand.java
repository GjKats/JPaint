package model;

import static model.shapes.ShapeFactory.createShape;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.persistence.ApplicationState;



public class CreateCommand implements ICommand {
    private ApplicationState state;
    private ShapeList shapeList;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;
    private IShape shapeToAdd;
    private int startX;
    private int startY;
    private int endX;
    private int endY;


    public CreateCommand(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        state = ApplicationState.getInstance();
        primaryColor = state.getActivePrimaryColor();
        secondaryColor = state.getActiveSecondaryColor();
        shadingType = state.getActiveShapeShadingType();
        shapeList = ShapeList.getInstance();
        shapeToAdd = initializeShape();
    }

    private IShape initializeShape() {
        IShape shape = null;
        switch (state.getActiveShapeType()) {
            case TRIANGLE:
                shape = createShape("TRIANGLE");
                break;
            case RECTANGLE:
                shape = createShape("RECTANGLE");
                break;
            case ELLIPSE:
                shape = createShape("ELLIPSE");
                break;
            default:
                break;
        }
        
        shape.setStartPoint(new Point(startX, startY));
        shape.setEndPoint(new Point(endX, endY));
        shape.setPrimaryColor(primaryColor);
        shape.setSecondaryColor(secondaryColor);
        shape.setShadingType(shadingType);
        System.out.print("Start point X: " + shape.getStartPoint().getX());
        System.out.print("\n");
        System.out.print("end point X: " +shape.getEndPoint().getX());
        System.out.print("\n");
        System.out.print("Start point Y: " + shape.getStartPoint().getY());
        System.out.print("\n");
        System.out.print("end point Y: " +shape.getEndPoint().getY());
        System.out.print("\n");
        return shape;
    }

    @Override
    public void run() {
        shapeList.shapeAdd(shapeToAdd);
    }

    @Override
    public void undoCommand() {
        shapeList.shapeRemove();
    }
}
