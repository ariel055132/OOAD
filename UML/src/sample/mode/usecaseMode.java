package sample.mode;

import javafx.scene.input.MouseEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import sample.object.classObject;
import sample.object.usecaseObject;

public class usecaseMode extends Mode{
    public usecaseMode() {}

    @Override
    public void setHandler() {
        canvas.addEventFilter(MouseEvent.ANY, mouseHandler);
    }

    @Override
    public void removeHandler() {
        canvas.removeEventFilter(MouseEvent.ANY, mouseHandler);
    }

    EventHandler mouseHandler = new EventHandler() {
        @Override
        public void handle(Event event) {
            MouseEvent mouseEvent = (MouseEvent) event;
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                objectArrayList.add(new usecaseObject(mouseEvent.getX(), mouseEvent.getY(), gc));
            }
        }
    };
}
