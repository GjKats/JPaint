package controller;

import model.persistence.ApplicationState;
import model.CreateCommand;
import model.MoveCommand;
import model.Point;
import model.SelectCommand;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {
    private Point startPoint;
    private Point endPoint;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    
    public MouseController() {}
    
    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY()); 
    }
    
    public void calculateDimensions () {
		startX = Math.min(startPoint.getX(), endPoint.getX());
		startY = Math.min(startPoint.getY(), endPoint.getY());
		endX = Math.max(startPoint.getX(), endPoint.getX());
		endY = Math.max(startPoint.getY(), endPoint.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	endPoint = new Point(e.getX(), e.getY());
    	
    	calculateDimensions();
    	
        if(ApplicationState.getInstance().getActiveStartAndEndPointMode() == ApplicationState.getInstance().getActiveStartAndEndPointMode().DRAW) {
        	CommandHistory.add(new CreateCommand(startX, startY, endX, endY));
        }
        else if(ApplicationState.getInstance().getActiveStartAndEndPointMode() == ApplicationState.getInstance().getActiveStartAndEndPointMode().SELECT) {
        	CommandHistory.add(new SelectCommand(startX, startY, endX, endY));
        }
        else if(ApplicationState.getInstance().getActiveStartAndEndPointMode() == ApplicationState.getInstance().getActiveStartAndEndPointMode().MOVE) {
        	CommandHistory.add(new MoveCommand(startPoint, endPoint));
        }
    }
}
