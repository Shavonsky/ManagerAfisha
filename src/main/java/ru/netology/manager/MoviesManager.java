package ru.netology.manager;


import ru.netology.domain.MoviesPostersInfo;

public class MoviesManager {
    MoviesPostersInfo[] items = new MoviesPostersInfo[0];
    int moviesQuantity;

    public MoviesManager(int moviesQuantity) {
        this.moviesQuantity = moviesQuantity;
    }

    public void add(MoviesPostersInfo film) {
        int length = items.length + 1;
        MoviesPostersInfo[] tmp = new MoviesPostersInfo[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        items = tmp;
    }

    public MoviesPostersInfo[] getAll() {
        MoviesPostersInfo[] result = new MoviesPostersInfo[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - 1 - i;
            result[i] = items[index];
        }
        return result;
    }

    public MoviesPostersInfo[] getSeveral() {
        int length = moviesQuantity;
        MoviesPostersInfo[] result = new MoviesPostersInfo[length];
        MoviesPostersInfo[] tmp = getAll();
        System.arraycopy(tmp, 0, result, 0, length);
        return result;
    }

}
