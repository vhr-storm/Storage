package com.example.storage.functional;

import com.example.storage.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {

    private final Map<String, Resume> MAP_UUID = new HashMap<>();

    @Override
    public void clear() {
        MAP_UUID.clear();
    }

    @Override
    protected List<Resume> getAllResumes() {
        return new ArrayList<>(MAP_UUID.values());
    }

    @Override
    String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    boolean isExist(String searchKey) {
        return MAP_UUID.containsKey(searchKey);
    }

    @Override
    void doSave(Resume r, String searchKey) {
        MAP_UUID.put(searchKey, r);
    }

    @Override
    Resume doGet(String searchKey) {
        return MAP_UUID.get(searchKey);
    }

    @Override
    void doDelete(String searchKey) {
        MAP_UUID.remove(searchKey);
    }

    @Override
    void doUpdate(Resume r, String searchKey) {
        MAP_UUID.put(searchKey, r);
    }

}
