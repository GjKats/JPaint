package model;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import java.util.ArrayList;
import java.util.List;

public class DeleteCommand implements ICommand {
    private ShapeList shapeList;
    private List<IShape> deletedShapes;
    private List<Integer> shapeIndex;

    public DeleteCommand() {
        shapeList = ShapeList.getInstance();
        deletedShapes = new ArrayList<>();
        shapeIndex = new ArrayList<>();
    }

    @Override
    public void run() {
        for(IShape shape : shapeList.getShapes()) {
            deletedShapes.add(shape);
            shapeIndex.add(shapeList.getShapes().indexOf(shape));
        }
        shapeList.deleteShapes();
    }

    @Override
    public void undoCommand() {
        for(int i = 0; i < deletedShapes.size(); i++) {
            shapeList.getShapes().add(shapeIndex.get(i), deletedShapes.get(i));
        }
        shapeList.notifyObservers();
    }
}
