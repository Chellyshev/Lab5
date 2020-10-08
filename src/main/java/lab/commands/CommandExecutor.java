package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

/**
 * Интерфейс обработчика команды.
 */
public interface CommandExecutor {
    Response executeTask(CollectionControl collectionControl, Task task);

}
