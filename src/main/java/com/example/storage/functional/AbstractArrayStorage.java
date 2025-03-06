package com.example.storage.functional;

import com.example.storage.exception.StorageException;
import com.example.storage.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

    protected final int MAXIMUM_SIZE = 10000;
    protected final Resume[] storage = new Resume[MAXIMUM_SIZE];
    protected int counterOfResume = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, counterOfResume, null);
        counterOfResume = 0;
    }


    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        if (counterOfResume >= MAXIMUM_SIZE) {
            throw new StorageException("Storage overflow");
        }
        insertElement(r, searchKey);
        counterOfResume++;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage[searchKey];
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        storage[searchKey] = r;
    }

    @Override
    void doDelete(Integer searchKey) {
        fillDeletedElement(searchKey);
        storage[counterOfResume - 1] = null;
        counterOfResume--;
    }

    @Override
    protected List<Resume> getAllResumes() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, counterOfResume));
    }

    protected abstract void insertElement(Resume r, int index);

    // Метод корректировки массива при удалении элемента.
    protected abstract void fillDeletedElement(int index);

}
