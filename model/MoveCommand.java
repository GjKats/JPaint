package model;

import model.interfaces.ICommand;

public class MoveCommand implements ICommand {
    private int distanceX; 
    private int distanceY;
    private ShapeList shapeList;

    public MoveCommand(Point startPoint, Point endPoint) {
        distanceX = endPoint.getX() - startPoint.getX();
        distanceY = endPoint.getY() - startPoint.getY();
        shapeList = ShapeList.getInstance();
    }

    @Override
    public void run() {
        shapeList.moveShapes(distanceX, distanceY);
    }

    @Override
    public void undoCommand() {
        shapeList.moveShapes(-distanceX, -distanceY);
    }
}
