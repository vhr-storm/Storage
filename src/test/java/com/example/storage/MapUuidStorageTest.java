package com.example.storage;

import com.example.storage.functional.AbstractStorage;
import com.example.storage.functional.StorageFactory;

public class MapUuidStorageTest extends AbstractStorageTest {


    @Override
    AbstractStorage getStorage() {
        return StorageFactory.createStorage(StorageFactory.StorageType.MAP_UUID_STORAGE);
    }


}
