package lab.commands;

import lab.CollectionControl;
import lab.collection.Movie;
import lab.worker.Response;
import lab.worker.Task;

public class CommandAdd implements Command {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        Movie movie = (Movie) task.getFirstArgument();
        Long id = (collectionControl.generateId());
        int startSize = collectionControl.getCollection().size();
        movie.setId(id);
        collectionControl.getCollection().add(movie);
        if (startSize == collectionControl.getCollection().size())
            msg = "Ошибка добавления элемента. ";
        else msg = "Элемент успешно добавлен";
        return new Response(msg);
    }
}
