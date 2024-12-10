package com.canvas.Model.DB;

public interface SaveLoad<T> {

    void saveData();

    T loadData();

}
