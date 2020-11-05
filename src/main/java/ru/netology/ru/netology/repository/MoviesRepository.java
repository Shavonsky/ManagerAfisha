package ru.netology.ru.netology.repository;

import ru.netology.domain.MoviesPostersInfo;

public class MoviesRepository {
    MoviesPostersInfo[] items = new MoviesPostersInfo[0];

    public MoviesPostersInfo[] findAll() {
        return items;
    }

    public void save(MoviesPostersInfo item) {
        int length = items.length + 1;
        MoviesPostersInfo[] tmp = new MoviesPostersInfo[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MoviesPostersInfo[] findByID(int id) {
        MoviesPostersInfo[] result = new MoviesPostersInfo[1];
        for (MoviesPostersInfo item : items) {
            if (item.getId() == id) {
                result[0] = item;
            }
        }
        return result;
    }

    public void removeByID(int id) {
        int length = items.length - 1;
        MoviesPostersInfo[] tmp = new MoviesPostersInfo[length];
        int index = 0;
        for (MoviesPostersInfo item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void removeAll() {
        MoviesPostersInfo[] del = new MoviesPostersInfo[0];
        items = del;
    }
}
