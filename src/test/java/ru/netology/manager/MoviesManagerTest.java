package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MoviesPostersInfo;
import ru.netology.ru.netology.repository.MoviesRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MoviesManagerTest {
    @Mock
    private MoviesRepository repository;
    @InjectMocks
    private MoviesManager manager;

    private MoviesPostersInfo first = new MoviesPostersInfo(1,"Movie 1",  1, "Thriller");
    private MoviesPostersInfo second = new MoviesPostersInfo(2,"Movie 2", 2, "Cartoon");
    private MoviesPostersInfo third = new MoviesPostersInfo(3,"Movie 3", 3, "Comedy");
//    private MoviesPostersInfo fourth = new MoviesPostersInfo(4,"Movie 4", 4, "Thriller");
//    private MoviesPostersInfo fifth = new MoviesPostersInfo(5,"Movie 5", 5, "Horror");
//    private MoviesPostersInfo sixth = new MoviesPostersInfo(6,"Movie 6", 6, "Cartoon");
//    private MoviesPostersInfo seventh = new MoviesPostersInfo(7,"Movie 7", 7, "Comedy");
//    private MoviesPostersInfo eighth = new MoviesPostersInfo(8,"Movie 8", 8, "Thriller");
//    private MoviesPostersInfo ninth = new MoviesPostersInfo(9,"Movie 9", 9, "Cartoon");
//    private MoviesPostersInfo tenth = new MoviesPostersInfo(10,"Movie 10", 10, "Comedy");

    @BeforeEach
    void setUp() {
    manager.add(first);
    manager.add(second);
    manager.add(third);
//    manager.add(fourth);
//    manager.add(fifth);
//    manager.add(sixth);
//    manager.add(seventh);
//    manager.add(eighth);
//    manager.add(ninth);
//    manager.add(tenth);
    }

    @Test
    public void shouldGetEmpty() {
        MoviesPostersInfo[] returned = new MoviesPostersInfo[0];
        doReturn(returned).when(repository).findAll();

        MoviesPostersInfo[] expected = new MoviesPostersInfo[0];
        MoviesPostersInfo[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldRemoveByID() {
        int idToRemove = 3;
        MoviesPostersInfo[] returned = new MoviesPostersInfo[]{first, second};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeByID(idToRemove);

        manager.removeByID(idToRemove);
        MoviesPostersInfo[] expected = new MoviesPostersInfo[]{second, first};
        MoviesPostersInfo[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeByID(idToRemove);
    }

    @Test
    public void shouldFindByID() {
        int idToFind = 2;
        MoviesPostersInfo[] returned = new MoviesPostersInfo[]{second};
        doReturn(returned).when(repository).findByID(idToFind);

        MoviesPostersInfo[] expected = new MoviesPostersInfo[]{second};
        MoviesPostersInfo[] actual = manager.findByID(idToFind);
        assertArrayEquals(expected, actual);

        verify(repository).findByID(idToFind);
    }

//    @Test
//    public void shouldFindByArrayID() {
//        setUp();
//        int idToFind = 2;
//        MoviesPostersInfo[] returned = new MoviesPostersInfo[]{first, second, third};
//        doReturn(returned).when(repository).findAll();
//
//        MoviesPostersInfo[] expected = new MoviesPostersInfo[]{first};
//        MoviesPostersInfo[] actual = manager.findByArrayID(idToFind);
//        assertArrayEquals(expected, actual);
//
//        verify(repository).findAll();
//    }

    @Test
    public void shouldRemoveAll() {
        MoviesPostersInfo[] returned = new MoviesPostersInfo[0];
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeAll();

        manager.removeAll();
        MoviesPostersInfo[] expected = new MoviesPostersInfo[0];
        MoviesPostersInfo[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
        verify(repository).removeAll();
    }

//    @Test
//    public void shouldGetSeveral() {
//        setUp();
//        int quantity = 2;
//        MoviesPostersInfo[] returned = new MoviesPostersInfo[]{first, second, third};
//        doReturn(returned).when(repository).findAll();
//
//        manager.moviesQuantity(quantity);
//        MoviesPostersInfo[] expected = new MoviesPostersInfo[]{third, second};
//        MoviesPostersInfo[] actual = manager.getSeveral();
//        assertArrayEquals(expected, actual);
//
//        verify(repository).findAll();
//    }

}