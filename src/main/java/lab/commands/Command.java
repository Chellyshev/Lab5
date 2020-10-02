package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

/**
 * Интерфейс обработчика команды.
 */
public interface Command {
    Response executeTask(CollectionControl collectionControl, Task task);

}
