package model;

import model.interfaces.ICommand;
import model.interfaces.IShape;

import java.util.ArrayList;

public class PasteCommand implements ICommand {
    private ShapeList shapeList;
    private int numberToPaste;

    public PasteCommand() {
        shapeList = ShapeList.getInstance();
        numberToPaste = 0;
    }

    @Override
    public void run() {
        numberToPaste = shapeList.getCopiedShapes().size();
        shapeList.pasteShapes();
    }

    @Override
    public void undoCommand() {
        ArrayList<IShape> shapes = shapeList.getShapes();
        int index = shapes.size() - 1;
        for(int i = 0; i < numberToPaste; i++) {
            shapes.remove(index);
            index -= 1;
        }
    }
}
