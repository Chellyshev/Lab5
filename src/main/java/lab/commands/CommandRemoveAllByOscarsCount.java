package lab.commands;

import lab.CollectionControl;
import lab.worker.Response;
import lab.worker.Task;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CommandRemoveAllByOscarsCount implements Command {

    @Override
    public Response executeTask(CollectionControl collectionControl, Task task) {
        String msg;
        int startSize = collectionControl.getCollection().size();
        collectionControl.getCollection().removeAll(collectionControl.getCollection().stream()
                .filter(m->m.getOscarsCount()==(Long) task.getFirstArgument()).collect(Collectors.toCollection(ArrayList::new)));
        if (startSize == collectionControl.getCollection().size())
            msg = "Элемент коллекции не был удалён.Возможно, он не существует.";
        else msg = "Элемент коллекции был удалён.";
        return new Response(msg);
    }
}
