package lab.collection;

import java.time.LocalDateTime;

public class Movie {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long oscarsCount; //Значение поля должно быть больше 0
    private Integer totalBoxOffice; //Поле не может быть null, Значение поля должно быть больше 0
    private MovieGenre genre; //Поле может быть null
    private MpaaRating mpaaRating; //Поле не может быть null
    private Person director; //Поле не может быть null
    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setOscarsCount(Long oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    public void setMovieGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public void setMpaaRating(MpaaRating mpaaRating) { this.mpaaRating = mpaaRating; }

    public void setPerson(Person director) {
        this.director = director;
    }

    public void setTotalBoxOffice(Integer totalBoxOffice) {
        this.totalBoxOffice = totalBoxOffice;
    }



    public Movie(long id,String name, Coordinates coordinates, LocalDateTime creationDate, Long oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person director, Integer totalBoxOffice) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.director = director;
        this.totalBoxOffice = totalBoxOffice;
    }

    public String getName() {
        return name;
    }

    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

    public MovieGenre getMovieGenre() {
        return genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", oscarsCount=" + oscarsCount +
                ", totalBoxOffice=" + totalBoxOffice +
                ", genre=" + genre +
                ", mpaaRating=" + mpaaRating +
                ", director=" + director +
                ", id=" + id +
                '}';
    }


    public int compareTo(Object o) {
        int thisValue = -1;
        if (this.getMpaaRating() != null) thisValue = this.getMpaaRating().value;
        int oValue = -1;
        if (((Movie) o).getMpaaRating() != null) oValue = ((Movie)o).getMpaaRating().value;

        return thisValue - oValue;
    }




    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Long getOscarsCount() {
        return oscarsCount;
    }

    public Integer getTotalBoxOffice() {
        return totalBoxOffice;
    }

    public Person getPerson() {
        return director;
    }
}
