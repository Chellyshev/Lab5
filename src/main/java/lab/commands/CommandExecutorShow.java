package lab.commands;

import lab.CollectionControl;
import lab.collection.Movie;
import lab.worker.Response;
import lab.worker.Task;

public class CommandExecutorShow implements CommandExecutor {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        StringBuilder msg;
        if (collectionControl.getCollection().size() == 0) {
            msg = new StringBuilder("Коллекция пуста");
        } else {
            msg = new StringBuilder("Список коллекции:\n");
            for (Movie movie : collectionControl.getCollection()) {
                msg.append(movie.toString()).append("\n");
            }
        }
        return new Response(msg.toString());
    }
}
