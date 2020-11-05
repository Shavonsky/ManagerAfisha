package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviesPostersInfo;

import static org.junit.jupiter.api.Assertions.*;


public class MoviesManagerTest {
    MoviesManager manager = new MoviesManager(10);

    MoviesPostersInfo first = new MoviesPostersInfo(1,"Movie 1",  1, "Thriller");
    MoviesPostersInfo second = new MoviesPostersInfo(2,"Movie 2", 2, "Cartoon");
    MoviesPostersInfo third = new MoviesPostersInfo(3,"Movie 3", 3, "Comedy");
    MoviesPostersInfo fourth = new MoviesPostersInfo(4,"Movie 4", 4, "Thriller");
    MoviesPostersInfo fifth = new MoviesPostersInfo(5,"Movie 5", 5, "Horror");
    MoviesPostersInfo sixth = new MoviesPostersInfo(6,"Movie 6", 6, "Cartoon");
    MoviesPostersInfo seventh = new MoviesPostersInfo(7,"Movie 7", 7, "Comedy");
    MoviesPostersInfo eighth = new MoviesPostersInfo(8,"Movie 8", 8, "Thriller");
    MoviesPostersInfo ninth = new MoviesPostersInfo(9,"Movie 9", 9, "Cartoon");
    MoviesPostersInfo tenth = new MoviesPostersInfo(10,"Movie 10", 10, "Comedy");


//@BeforeEach
//    void setUp() {
//    manager.add(first);
//    manager.add(second);
//    manager.add(third);
//    manager.add(fourth);
//    manager.add(fifth);
//    manager.add(sixth);
//    manager.add(seventh);
//    manager.add(eighth);
//    manager.add(ninth);
//    manager.add(tenth);
//    }

    @Test
    void shouldNoting() {
        MoviesPostersInfo[] expected = new MoviesPostersInfo[0];
        MoviesPostersInfo[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldOneMovie() {
        manager.add(first);
        MoviesPostersInfo[] expected = new MoviesPostersInfo[]{first};
        MoviesPostersInfo[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAll() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        MoviesPostersInfo[] expected = new MoviesPostersInfo[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MoviesPostersInfo[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetSeveral() {
        MoviesManager manager = new MoviesManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        MoviesPostersInfo[] expected = new MoviesPostersInfo[]{tenth, ninth, eighth, seventh, sixth};
        MoviesPostersInfo[] actual = manager.getSeveral();
        assertArrayEquals(expected, actual);
    }

}