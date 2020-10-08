package lab.commands;

import lab.CollectionControl;
import lab.collection.Movie;
import lab.worker.Response;
import lab.worker.Task;

public class CommandExecutorRemoveAllByOscarsCount implements CommandExecutor {

    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        int startSize = collectionControl.getCollection().size();
        long OscarCount = (long) task.getFirstArgument();
        for(Movie movie : collectionControl.getCollection()){
            if(movie.getOscarsCount() == OscarCount ) collectionControl.getCollection().remove(movie);
        }
        if(collectionControl.getCollection().size() == startSize)
            msg = "Элемент коллекции не был удалён.Возможно, он не существует.";
       else msg = "Элемент коллекции был удалён.";
        return new Response(msg);
    }
}
