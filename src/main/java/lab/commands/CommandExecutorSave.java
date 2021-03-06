package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

public class CommandExecutorSave implements CommandExecutor {
    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        if (collectionControl.saveCollection())
            return new Response("Коллекция успешно сохранена");
        else return new Response("Ошибка сохранения коллекции");
    }
}
