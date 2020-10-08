package lab.commands;

import lab.CollectionControl;
import lab.collection.Movie;
import lab.collection.MovieGenre;
import lab.worker.Response;
import lab.worker.Task;

public class CommandExecutorFilterByGenre implements CommandExecutor {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        StringBuilder msg;
        if (collectionControl.getCollection().size() == 0) {
            msg = new StringBuilder("Коллекция пуста");
        } else {
            msg = new StringBuilder("Элементов коллекции с Полем MovieGenre, равным: "+(MovieGenre)task.getFirstArgument()+"\n");
            for (Movie movie : collectionControl.getCollection()) {
                if (((MovieGenre)task.getFirstArgument()).equals(movie.getMovieGenre()))
                {
                msg.append(movie.toString()).append("\n"); }
            }

        }
        return new Response(msg.toString());
    }
}

