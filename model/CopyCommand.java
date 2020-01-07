package model;

import java.util.ArrayList;
import java.util.List;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.shapes.ShapeFactory;

public class CopyCommand implements ICommand {
    private ShapeList shapeList;
    private List<IShape> pastCopies;

    public CopyCommand() {
        this.shapeList = ShapeList.getInstance();
        this.pastCopies = new ArrayList<>();
    }

    @Override
    public void run() {
        for(IShape shape : shapeList.getCopiedShapes()) {
            pastCopies.add(ShapeFactory.copyShape(shape));
        }
        shapeList.copyShapes();
    }

    @Override
    public void undoCommand() {
        shapeList.getCopiedShapes().clear();
        for(IShape shape : pastCopies) {
            shapeList.getCopiedShapes().add(shape);
        }
    }
}
