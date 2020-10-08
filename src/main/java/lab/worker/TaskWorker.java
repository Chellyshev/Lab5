package lab.worker;

import lab.CollectionControl;
import lab.commands.*;

import java.util.HashMap;

/**
 * Класс обработки заданий.
 */
public class TaskWorker {
    CollectionControl collectionControl;
    HashMap<CommandType, CommandExecutor> commandList = new HashMap<>();

    {
        commandList.put(CommandType.CLEAR, new CommandExecutorClear());
        commandList.put(CommandType.EXECUTE_SCRIPT, new CommandExecutorExecuteScript(this));
        commandList.put(CommandType.HELP, new CommandExecutorHelp());
        commandList.put(CommandType.ADD, new CommandExecutorAdd());
        commandList.put(CommandType.REMOVE_KEY, new CommandExecutorRemoveKey());
        commandList.put(CommandType.SAVE, new CommandExecutorSave());
        commandList.put(CommandType.UPDATE, new CommandExecutorUpdate());
        commandList.put(CommandType.SHOW, new CommandExecutorShow());
        commandList.put(CommandType.INFO, new CommandExecutorInfo());
        commandList.put(CommandType.SHUFFLE, new CommandExecutorShuffle());
        commandList.put(CommandType.REMOVE_BY_OSCAR_COUNT, new CommandExecutorRemoveAllByOscarsCount());
        commandList.put(CommandType.FILTER_BY_GENRE,new CommandExecutorFilterByGenre());
        commandList.put(CommandType.ADD_IF_MIN, new CommandExecutorAddIfMin());
        commandList.put(CommandType.FILTER_BY_NAME, new CommandExecutorFilterContainsName());
        commandList.put(CommandType.SORT, new CommandExecutorSort());
    }

    public TaskWorker(CollectionControl collectionControl) {
        this.collectionControl = collectionControl;
    }

    /**
     * Выполняет задание.
     *
     * @param task Задание, сформированное из команды.
     * @return Ответ, результат выполнения.
     */
    public Response executeTask(Task task) {
        CommandType commandType = task.getType();
        CommandExecutor commandExecutor = commandList.get(commandType);
        Response response = commandExecutor.executeTask(collectionControl, task);
        return response;
    }
}
