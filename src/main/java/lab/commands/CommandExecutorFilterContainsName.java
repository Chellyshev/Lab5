package lab.commands;

import lab.CollectionControl;
import lab.collection.Movie;
import lab.worker.Response;
import lab.worker.Task;

public class CommandExecutorFilterContainsName implements CommandExecutor {


    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        StringBuilder msg;
        String arg = (String) task.getFirstArgument();
        if (collectionControl.getCollection().size() == 0) {
            msg = new StringBuilder("Коллекция пуста");
        } else {
            msg = new StringBuilder("Элементы коллекции значение поля name которых содержит : "+    arg +"\n");
            for (Movie movie : collectionControl.getCollection()) {
                if (movie.getName().contains(arg))
                {
                    msg.append(movie.toString()).append("\n"); }
            }



        }
        return new Response(msg.toString());
    }
}
