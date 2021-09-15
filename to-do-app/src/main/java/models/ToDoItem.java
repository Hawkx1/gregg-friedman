package models;

public class ToDoItem {
    private String toDoText;
    private boolean complete;

    public ToDoItem() {
        complete = false;
    }

    public ToDoItem(String toDoText) {
        complete = false;
        this.toDoText = toDoText;
    }

    public String getToDoText() {
        return toDoText;
    }

    public void setToDoText(String toDoText) {
        this.toDoText = toDoText;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
