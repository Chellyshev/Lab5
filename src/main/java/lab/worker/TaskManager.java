package lab.worker;

import com.google.gson.Gson;
import lab.collection.Movie;
import lab.collection.MovieGenerator;
import lab.collection.MovieGenre;
import lab.commands.CommandType;

import java.util.ArrayList;

/**
 * Класс, работающий с командами из консоли.
 */
public class TaskManager {
    private static final int HISTORY_SIZE = 7;
    private final String[] taskHistory = new String[HISTORY_SIZE];
    Gson gson = new Gson();

    /**
     * Обновляет исхорию команд пользователя.
     *
     * @param newElement Команда, которую нужно добавить в историю.
     */
    private void updateHistory(String newElement) {
        for (int i = HISTORY_SIZE - 1; i >= 1; i--) {
            taskHistory[i] = taskHistory[i - 1];
        }
        taskHistory[0] = newElement;
    }

    /**
     * Выводит историю команд пользователя.
     */
    private void getHistory() {
        System.out.println("История запросов:");
        for (String element : taskHistory) {
            if (element != null)
                System.out.println(element);
        }
    }

    /**
     * Расшифровыывет команду пользователя и формирует задание.
     *
     * @param stringTask Команда пользователя в строковом представлениию
     * @return Задание программе.
     */
    public Task getTask(String stringTask, boolean isScriptCommand) {
        Task task = null;
        String command = stringTask.trim().split(" ", 2)[0];
        updateHistory(command);
        try {
            switch (command) {
                case "help":
                    task = new Task(CommandType.HELP);
                    break;
                case "info":
                    task = new Task(CommandType.INFO);
                    break;
                case "show":
                    task = new Task(CommandType.SHOW);
                    break;
                case "clear":
                    task = new Task(CommandType.CLEAR);
                    break;
                case "save":
                    task = new Task(CommandType.SAVE);
                    break;
                case "exit":
                    System.exit(0);
                    break;

                case "add":
                    try {
                        if (!isScriptCommand) {
                            Movie movie = MovieGenerator.generate();
                                task = new Task(CommandType.ADD, movie);
                        } else {
                            Movie movie = gson.fromJson(stringTask.trim().split(" ", 2)[1].trim().split(" ")[1], Movie.class);
                            if (MovieGenerator.checkMovie(movie))
                                task = new Task(CommandType.ADD, movie);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа");
                    }
                    break;
                case "update":
                    Long updateId;
                    try {
                        updateId = Long.parseLong(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                        if (!isScriptCommand) {
                            Movie updateSpaceMarine = MovieGenerator.generate();
                            if (updateId != null && updateSpaceMarine != null) {
                                updateSpaceMarine.setId(updateId);
                                task = new Task(CommandType.UPDATE, updateSpaceMarine);
                            }
                        } else {
                            Movie movie = gson.fromJson(stringTask.trim().split(" ", 2)[1].trim().split(" ")[1], Movie.class);
                            if (MovieGenerator.checkMovie(movie))
                               movie.setId(updateId);
                            task = new Task(CommandType.UPDATE, movie);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа (id)");
                    }
                    break;
                case "remove_key":
                    Long removeId = null;
                    try {
                        removeId = Long.parseLong(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа (id)");
                    }
                    if (removeId != null) {
                        task = new Task(CommandType.REMOVE_KEY, removeId);
                    }
                    break;

                case "execute_script":
                    String file = stringTask.trim().split(" ", 2)[1];
                    ScriptReader scriptReader = new ScriptReader();
                    ArrayList<Task> taskList = scriptReader.read(file);
                    if (taskList != null) {
                        task = new Task(CommandType.EXECUTE_SCRIPT, taskList);
                    }
                    break;
                case "shuffle":
                    task = new Task(CommandType.SHUFFLE);
                    break;
                case "remove_all_by_oscars_count":
                    Long removeOscar = null;
                    try {
                        removeOscar = Long.parseLong(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа (id)");
                    }
                    if (removeOscar != null) {
                        task = new Task(CommandType.REMOVE_BY_OSCAR_COUNT,removeOscar);
                    }
                    break;
                case "filter_by_genre":
                    try {
                        MovieGenre showGenre;
                        showGenre = MovieGenre.valueOf(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                        task = new Task(CommandType.FILTER_BY_GENRE, showGenre);
                    }catch (IllegalArgumentException e){
                        System.out.println("Ошибка ввода. Список доступных значений:");
                        for (MovieGenre movieg:MovieGenre.values()) {
                            System.out.println(movieg);                            
                        }
                    }break;
                case "add_if_min":
                    try {
                        if (!isScriptCommand) {
                            Movie movie = MovieGenerator.generate();
                            task = new Task(CommandType.ADD_IF_MIN, movie);
                        } else {
                            Movie movie = gson.fromJson(stringTask.trim().split(" ", 2)[1].trim().split(" ")[1], Movie.class);
                            if (MovieGenerator.checkMovie(movie))
                                task = new Task(CommandType.ADD_IF_MIN, movie);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода числа");
                    }
                    break;
                case "filter_contains_name":
                        String arg;
                        arg = String.valueOf(stringTask.trim().split(" ", 2)[1].trim().split(" ")[0]);
                        task = new Task(CommandType.FILTER_BY_NAME, arg);

                    break;
                case "sort":
                    task = new Task(CommandType.SORT);
                    break;

                default:
                    System.out.println("Команда " + command + " неопознана. Введите 'help' для получения списка команд");

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Команда " + command + " требует аргумент");
        }
        return task;
    }
}
