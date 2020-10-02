package lab.commands;

import lab.CollectionControl;
import lab.collection.Movie;
import lab.worker.Response;
import lab.worker.Task;



public class CommandSort implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        if (collectionControl.getCollection().size() == 0) {
            msg = "Коллекция пуста";
        } else {
            collectionControl.getCollection().sort(Movie::compareTo);
            msg = "Элементы коллекции отсортированы";

        } return new Response(msg);
    }
}
