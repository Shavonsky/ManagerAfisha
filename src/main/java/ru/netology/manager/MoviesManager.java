package ru.netology.manager;


import ru.netology.domain.MoviesPostersInfo;
import ru.netology.ru.netology.repository.MoviesRepository;

public class MoviesManager {
    int moviesQuantity;
    MoviesRepository repository;

    public MoviesManager(MoviesRepository repository) { this.repository = repository; }


    public void add(MoviesPostersInfo item) { repository.save(item);}

    public MoviesPostersInfo[] findByID(int id) {
        MoviesPostersInfo[] result = repository.findByID(id);
        return result;
    }

    public void removeByID(int id) { repository.removeByID(id); }

    public void removeAll() { repository.removeAll(); }

    public MoviesPostersInfo[] getAll() {
        MoviesPostersInfo[] items = repository.findAll();
        MoviesPostersInfo[] result = new MoviesPostersInfo[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

//    public MoviesPostersInfo[] getSeveral() {
//        int length = moviesQuantity;
//        MoviesPostersInfo[] result = new MoviesPostersInfo[length];
//        MoviesPostersInfo[] tmp = getAll();
//        System.arraycopy(tmp, 0, result, 0, length);
//        return result;
//    }
//
//    public int moviesQuantity(int quantity) { return quantity;}
}
