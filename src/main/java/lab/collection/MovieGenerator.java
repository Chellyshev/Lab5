package lab.collection;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MovieGenerator {

    public static Movie generate() {
        Movie movie = null;
        try {
            Scanner scanner = new Scanner(System.in);
            String name;
            do {
                System.out.println("Введите имя Movie:");
                name = scanner.nextLine();
            } while (name.isEmpty());
            Long x = null;
            do {
                System.out.println("Введите координату X:");
                try {
                    x = Long.valueOf(scanner.nextLine());
                    if (x > 618) {
                        System.out.println("Число должно быть меньше 618");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                }
            } while (x == null || x > 618);
            Double y = null ;
            do {
                System.out.println("Введите координату Y:");
                try {
                    y = Double.valueOf(scanner.nextLine());
                    if (y > 840) {
                        System.out.println("Число должно быть меньше 840");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                }
            } while (y == null || y > 840);

            Integer totalBoxOffice = null ;
            do {
                System.out.println("Введите значение totalBoxOffice:");
                try {
                    totalBoxOffice = Integer.valueOf(scanner.nextLine());
                    if (totalBoxOffice < 0) {
                        System.out.println("Число должно быть больше 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                }
            } while (totalBoxOffice == null || totalBoxOffice < 0);

            MovieGenre genre = null;
            while (true) {
                System.out.println("Введите поле MovieGenre (для ввода null используйте пустую строку).");
                System.out.println("Доступные варианты:");
                for (MovieGenre category1 : MovieGenre.values()) System.out.println(category1.toString());
                try {
                    String string = scanner.nextLine();
                    if (string.isEmpty()) break;
                    genre = MovieGenre.valueOf(string);
                } catch (IllegalArgumentException e) {
                    System.out.println("Ввода ввода");
                    continue;
                }
                break;
            }

            MpaaRating mpaaRating;
            while (true) {
                System.out.println("Введите поле MpaaRating");
                System.out.println("Доступные варианты:");
                for (MpaaRating mpaaRating1 : MpaaRating.values()) System.out.println(mpaaRating1.toString());
                try {
                    String string = scanner.nextLine();
                    mpaaRating = MpaaRating.valueOf(string);
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка ввода");
                    continue;
                }
                break;
            }

            String directorName = "";
            do {
                System.out.println("Введите имя Director:");
                directorName = scanner.nextLine();
            } while (directorName.isEmpty());

            Long oscarsCount = null;
            do {
                System.out.println("Введите поле oscarsCount:");
                try {
                    oscarsCount = Long.valueOf(scanner.nextLine());
                    if (oscarsCount <= 0) {
                        System.out.println("Значение поля должно быть больше 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                }
            } while (oscarsCount == null || oscarsCount <= 0);

            Float weight = null;
            do {
                System.out.println("Введите поле Weight:");
                try {
                    weight = Float.valueOf(scanner.nextLine());
                    if (weight <= 0) {
                        System.out.println("Значение поля должно быть больше 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                }
            } while (weight == null || weight <= 0);
            Color eyeColor = null;
            while (true) {
                System.out.println("Введите поле EyeColor");
                System.out.println("Доступные варианты:");
                for (Color eyeColor1 : Color.values()) System.out.println(eyeColor1.toString());
                try {
                    String string = scanner.nextLine();
                    eyeColor = Color.valueOf(string);
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка ввода");
                    continue;
                }
                break;
            }
            Long xloc = null;
            do {
                System.out.println("Введите координату X:");
                try {
                    xloc = Long.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                }
            } while (xloc == null || x > 618);
            double yloc;
            while (true) {
                System.out.println("Введите координату Y:");
                try {
                    yloc = Double.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                    continue;
                }
                break;
            }
            double z;
            while (true) {
                System.out.println("Введите координату Z:");
                try {
                    z = Double.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа");
                    continue;
                }
                break;
            }
            Coordinates coordinates = new Coordinates(x,y);
            Location location = new Location(xloc, yloc, z);
            Person person = new Person(directorName, weight, eyeColor, location);
            movie = new Movie(1, name,coordinates,LocalDateTime.now(),oscarsCount,genre,mpaaRating,person,totalBoxOffice);
        } catch (NoSuchElementException e) {
            System.out.println("Ввод был завершён...");
        }
        return movie;
    }


    public static boolean checkMovie(Movie movie) {
        boolean status = true;
        if (movie.getName() == null || movie.getName().isEmpty()) {
            System.out.println("Movie Name не может быть null или пустым");
            status = false;
        }
        if (movie.getCoordinates() == null || movie.getCoordinates().getX() == null ||
                movie.getCoordinates().getY() == null || movie.getCoordinates().getX() > 618 || movie.getCoordinates().getY() > 840) {
            System.out.println("Movie Coordinates не может быть null, x < 618, y < 840 ");
            status = false;
        }
        if (movie.getOscarsCount() <= 0) {
            System.out.println("Movie OscarCount > 0");
            status = false;
        }
        if (movie.getMpaaRating() == null) {
            System.out.println("Movie MpaaRating не может быть null");
            status = false;
        }
        if (movie.getMovieGenre() == null) {
            System.out.println("Movie Genre не может быть null");
            status = false;
        }
        if (movie.getPerson() == null) {
            System.out.println("Movie Person не может быть null");
            status = false;
        } else {
            if (movie.getPerson() == null || movie.getPerson().getName().isEmpty()) {
                System.out.println("Movie Person's Name не может быть null или пустым");
                status = false;
            }
            if (movie.getPerson().getWeight() == null ||
                    movie.getPerson().getWeight() <= 0) {
                System.out.println("Movie Person's Weight не может быть null, 0 < Weight <=1000");
                status = false;
            }
            if (movie.getPerson().getEyeColor() == null) {
                System.out.println("Movie Person's EyeColor не может быть null");
                status = false;
            }
            if (movie.getPerson().getLocation() == null) {
                System.out.println("Movie Person's Location не может быть null");
                status = false;
            }
        }
        return status;
    }
}




