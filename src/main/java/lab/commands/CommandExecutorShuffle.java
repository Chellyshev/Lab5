package lab.commands;
import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

import java.util.Collections;

public class CommandExecutorShuffle implements CommandExecutor {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {

        Collections.shuffle(collectionControl.getCollection());
        System.out.println("Элементы коллекции перемешаны");

        return null;
    }
}

