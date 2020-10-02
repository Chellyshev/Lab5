package lab.commands;

import lab.CollectionControl;
import lab.collection.Movie;
import lab.worker.Response;
import lab.worker.Task;



public class CommandSort implements Command{
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        collectionControl.getCollection().sort(Movie::compareTo);
        System.out.println("Элементы коллекции отсортированы");
        return null;
    }
}
