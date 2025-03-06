package com.example.storage.functional;

import com.example.storage.model.Resume;

import java.util.List;

public interface Storage {
    void clear();

    void save(Resume r);

    Resume get(String uuid);

    List<Resume> getAllSorted();

    void delete(String uuid);

    void update(Resume r);

    int size();

}
