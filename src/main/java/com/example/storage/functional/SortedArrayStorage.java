package com.example.storage.functional;

import com.example.storage.exception.*;
import com.example.storage.model.Resume;
import com.example.storage.exception.ExistStorageException;
import com.example.storage.exception.StorageException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/sorted-array")
public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    public void insertElement(Resume r, int index) throws StorageException {
        int insertId = -index - 1;
        if (insertId < 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            System.arraycopy(storage, insertId, storage, insertId + 1, counterOfResume - insertId);
            storage[insertId] = r;
        }
    }

    @Override
    protected void fillDeletedElement(int index) {
        int move = counterOfResume - index - 1;
        if (move > 0) {
            System.arraycopy(storage, index + 1, storage, index, move);
        }
    }

    @Override
    public Integer getSearchKey(String uuid) {
        return Arrays.binarySearch(storage, 0, counterOfResume, new Resume(uuid, "dummy"));
    }


}




