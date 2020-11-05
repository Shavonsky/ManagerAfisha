package ru.netology.ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviesPostersInfo;

import static org.junit.jupiter.api.Assertions.*;

class MoviesRepositoryTest {
    private MoviesRepository repository = new MoviesRepository();

    private MoviesPostersInfo first = new MoviesPostersInfo(1,"Movie 1",  1, "Thriller");
    private MoviesPostersInfo second = new MoviesPostersInfo(2,"Movie 2", 2, "Cartoon");
    private MoviesPostersInfo third = new MoviesPostersInfo(3,"Movie 3", 3, "Comedy");

    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    void shouldSaveOne() {
        repository.save(first);
        MoviesPostersInfo[] expected = new MoviesPostersInfo[]{first};
        MoviesPostersInfo[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        setUp();
        MoviesPostersInfo[] expected = new MoviesPostersInfo[]{first, second, third};
        MoviesPostersInfo[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        setUp();
        repository.removeAll();
        MoviesPostersInfo[] expected = new MoviesPostersInfo[0];
        MoviesPostersInfo[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByID() {
        setUp();
        repository.removeByID(2);
        MoviesPostersInfo[] expected = new MoviesPostersInfo[]{first, third};
        MoviesPostersInfo[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByFilmID() {
        setUp();
        MoviesPostersInfo[] expected = new MoviesPostersInfo[]{first};
        MoviesPostersInfo[] actual = repository.findByID(1);
        assertArrayEquals(expected, actual);
    }

}