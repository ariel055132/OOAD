package sample.mode;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import sample.object.classObject;

public class classMode extends Mode{
    public classMode() {}

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
                objectArrayList.add(new classObject(mouseEvent.getX(), mouseEvent.getY(), gc));
            }
        }
    };

}
