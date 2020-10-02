package lab;

import lab.collection.Movie;


import java.util.LinkedList;
import java.util.Random;

/**
 * Класс доступа к коллекции
 */
public class CollectionControl {
    FileManager fileManager = new FileManager();
    LinkedList<Movie> collection;

    public  LinkedList<Movie> getCollection() {
        return collection;
    }

    /**
     * Загружает коллекцию из файла.
     *
     * @param filePath Путь к файлу.
     * @return Успешность загрузки.
     */
    public boolean loadCollection(String filePath) {
        this.collection = fileManager.loadCollection(filePath);
        return collection != null;
    }

    /**
     * Сохраняет коллекцию в файл, из которого она была загружена.
     *
     * @return Успешность сохранения.
     */
    public boolean saveCollection() {
        return fileManager.save(collection);
    }

    /**
     * Выводит информацию о коллекции.
     */
    @Override
    public String toString() {
        return "Информация о коллекции:\n" +
                "Файл коллекции: " + fileManager.collectionFile.getAbsolutePath() + "\n" +
                "Тип коллекции: " + collection.getClass().toString();
    }

    public Long generateId() {
        Long newId = (new Random()).nextLong();
        for (Movie movie : collection) {
            if (movie.getId() == newId) newId = generateId();
        }
        return newId;
    }
}

