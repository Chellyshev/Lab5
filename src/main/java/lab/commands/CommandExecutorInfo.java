package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

public class CommandExecutorInfo implements CommandExecutor {
    public Response executeTask(CollectionControl collectionControl, Task task) {
        return new Response(collectionControl.toString());
    }
}
