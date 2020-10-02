package lab.commands;

import lab.CollectionControl;
import lab.collection.Movie;
import lab.collection.MovieGenre;
import lab.worker.Response;
import lab.worker.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class CommandAddIfMin implements Command {


    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        msg = "Попытка добавить элемент";
        Movie movie1 = (Movie) task.getFirstArgument();
        Long id = (collectionControl.generateId());
        int startSize = collectionControl.getCollection().size();
        movie1.setId(id);
        Movie min = collectionControl.getCollection().getFirst();
        for (Movie movie : collectionControl.getCollection()) {
            if (movie.compareTo(min) < 0) {
                min = movie;
            }}


            if(min.compareTo(movie1) >= 0)
            {
                collectionControl.getCollection().add(movie1);
                msg = "Элемент добавлен";
            }
            else msg = "Ошибка. Элемент не минимальный.";
        return new Response(msg);
        }
    }



