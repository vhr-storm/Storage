package com.example.storage;

import com.example.storage.functional.AbstractStorage;
import com.example.storage.functional.StorageFactory;

public class MapResumeStorageTest extends AbstractStorageTest{
    @Override
    AbstractStorage getStorage() {
        return StorageFactory.createStorage(StorageFactory.StorageType.MAP_RESUME_STORAGE);
    }
}
