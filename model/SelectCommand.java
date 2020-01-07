package model;

import model.interfaces.ICommand;
import model.interfaces.IShape;


public class SelectCommand implements ICommand {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private boolean[] previouslySelected;
    private ShapeList shapeList;

    public SelectCommand(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        shapeList = ShapeList.getInstance();
        int numberOfShapes = shapeList.getShapes().size();
        previouslySelected = new boolean[numberOfShapes];
    }

    @Override
    public void run() {
        for(IShape shape : shapeList.getShapes()) {
            int i = shapeList.getShapes().indexOf(shape);
            if(shape.isSelected())
                previouslySelected[i] = true;
            else
                previouslySelected[i] = false;
        }
        shapeList.selectShapes(startX, startY, endX, endY);
        shapeList.notifyObservers();
    }

    @Override
    public void undoCommand() {
        for(int i = 0; i < previouslySelected.length; i++) {
            if(previouslySelected[i])
                shapeList.getShapes().get(i).select();
            else
                shapeList.getShapes().get(i).unSelect();
        }
        shapeList.notifyObservers();
    }
}
