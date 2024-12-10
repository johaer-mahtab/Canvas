package com.canvas.Model.DB;

public interface SaveLoad {

    void saveData();

    <T>T loadData();

}
