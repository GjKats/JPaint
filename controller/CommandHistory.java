package controller;

import java.util.Stack;

import model.interfaces.ICommand;

class CommandHistory {
	private static final Stack<ICommand> undoStack = new Stack<ICommand>();
	private static final Stack<ICommand> redoStack = new Stack<ICommand>();

	public static void add(ICommand cmd) {
		cmd.run();
		undoStack.push(cmd);
		redoStack.clear();
	}
	
	public static void undo() {
		boolean result = !undoStack.empty();
		if (result) {
			ICommand c = undoStack.pop();
			c.undoCommand();
			redoStack.push(c);
		}
	}

	public static void redo() {
		boolean result = !redoStack.empty();
		if (result) {
			ICommand c = redoStack.pop();
			c.run();
			undoStack.push(c);
		}
	}
}
