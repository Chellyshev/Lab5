package lab.worker;

import lab.commands.CommandType;

/**
 * Класс задания программе.
 * @param <T> Первый аргумент .
 */
public class Task<T> {
    private CommandType type;
    private T firstArgument;

    public Task(CommandType type) {
        this.type = type;
    }

    public Task(CommandType type, T firstArgument) {
        this.type = type;
        this.firstArgument = firstArgument;
    }


    public T getFirstArgument() {
        return firstArgument;
    }


    public CommandType getType() {
        return type;
    }
}
