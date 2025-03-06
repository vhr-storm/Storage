package com.example.storage.functional;

import com.example.storage.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertElement(Resume r, int index) {
        storage[counterOfResume] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[counterOfResume - 1];
    }

    @Override
    public Integer getSearchKey(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }

        return -1;
    }
}
