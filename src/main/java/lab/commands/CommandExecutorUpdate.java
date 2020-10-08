package lab.commands;

import lab.CollectionControl;
import lab.collection.Movie;
import lab.worker.Response;
import lab.worker.Task;

public class CommandExecutorUpdate implements CommandExecutor {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {

        String msg;
        Movie movie = (Movie) task.getFirstArgument();
        Long id = (movie.getId());
        int startSize = collectionControl.getCollection().size();
        for (Movie forMovie : collectionControl.getCollection()) {
            if (forMovie.getId() == id) {
                collectionControl.getCollection().remove(forMovie);
            }
        }
        if (startSize == collectionControl.getCollection().size()) msg = "Элемента с id " + id + " не существует";
        else {
            collectionControl.getCollection().add(movie);
            msg = "Элемент изменён";
        }
        return new Response(msg);
    }

}
