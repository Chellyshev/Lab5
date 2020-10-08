package lab;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lab.collection.Movie;
import lab.collection.MovieGenerator;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class FileManager {
    File collectionFile;

    /**
     * Загружает коллекцию из файла, указанного в аргументе.
     *
     * @param filePath Путь к файлу коллекции.
     * @return Коллекция.
     */
    public LinkedList<Movie> loadCollection(String filePath) {
        LinkedList<Movie> collection = new LinkedList<Movie>();
        if (!setFile(filePath)) return null;
        else try ( InputStreamReader fr = new InputStreamReader(new FileInputStream(collectionFile), "UTF-8")) {
            BufferedReader bufferedReader = new BufferedReader(fr);
            Gson gson = new Gson();
            System.out.println("Загрузка коллекции из файла " + collectionFile.getAbsolutePath());
            StringBuilder stringBuilder = new StringBuilder();
            String nextString;
            while ((nextString = bufferedReader.readLine()) != null) {
                stringBuilder.append(nextString);
            }

            Type typeOfCollection = new TypeToken<LinkedList<Movie>>() {
            }.getType();
            try {
                LinkedList< Movie> addCollection = gson.fromJson(stringBuilder.toString(), typeOfCollection);
                if (addCollection != null)
                    for (Movie movie : addCollection) {
                    if (!MovieGenerator.checkMovie(movie)) {
                        System.out.println("Загружаемый элемент не удовлетворяет требованиям коллекции.");
                    }
                        collection.add(movie);
                    }
            } catch (JsonSyntaxException e) {
                System.out.println("Ошибка синтаксиса Json. Файл не может быть загружен.");
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Непредвиденная ошибка при считывании файла.");
                return null;
            }
            System.out.println("Коллекций успешно загружена. Добавлено " + collection.size() + " элементов.");
        } catch (IOException e) {
            System.out.println("При чтении строк возникла ошибка");

            return null;
        }
        return collection;
    }

    /**
     * Проверяет файл коллекции.
     *
     * @param path Путь к файлу
     * @return Результат проверки. true, если файл подходит для работы.
     */
    private boolean setFile(String path) {
        if (path == null) {
            System.out.println("File path " + path + " is wrong!!!");
            System.exit(1);
        }
        File jsonPath = new File(path);
        if (jsonPath.exists()) {
            setCollectionFile(jsonPath);
            System.out.println("Path " + path + " discovered.");
        } else {
            System.out.println("Path " + path + " does not exist.");
            try {
                System.out.println("Create a new file.");
                if (jsonPath.createNewFile()) {
                    System.out.println("File not created");
                }
                setCollectionFile(jsonPath);
                save(new LinkedList<>());
            } catch (IOException e) {
                System.out.println("Error creating file!!!");
                return false;
            }
        }
        if (!jsonPath.isFile()) {
            System.out.println("Path " + path + " does not contain a file name.");
            return false;
        } else {
            System.out.println("File " + path + " discovered.");
        }
        if (!(path.lastIndexOf(".json") == path.length() - 5)) {
            System.out.println("Non .json file format.");
            return false;
        }
        return true;
    }

    /**
     * Сохраняет коллекцию в файл.
     *
     * @param collection Коллекция.
     * @return Успешность операции сохранения.
     */
    public boolean save(LinkedList< Movie> collection) {
        Gson gson = new Gson();
        if (!collectionFile.exists()) {
            System.out.println(("Невозможно сохранить файл. Файл по указанному пути (" + collectionFile.getAbsolutePath() + ") не существует."));
        } else if (!collectionFile.canRead() || !collectionFile.canWrite()) {
            System.out.println("Невозможно сохранить файл. Файл защищён от чтения и(или) записи.");
        } else {
            try (OutputStream fileWriter = new FileOutputStream(collectionFile)) {
                fileWriter.write(gson.toJson(collection).getBytes(),0, gson.toJson(collection).length());
                fileWriter.flush();
                System.out.println("Файл успешно сохранён.");
                return true;
            } catch (Exception ex) {
                System.out.println("При записи файла что-то пошло не так.");
            }
        }
        return false;
    }

    private void setCollectionFile(File collectionFile) {
        this.collectionFile = collectionFile;
    }
}

