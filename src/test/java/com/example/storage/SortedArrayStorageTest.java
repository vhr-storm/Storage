package com.example.storage;

import com.example.storage.functional.AbstractStorage;
import com.example.storage.functional.StorageFactory;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {


    @Override
    AbstractStorage getStorage() {
        return StorageFactory.createStorage(StorageFactory.StorageType.SORTED_ARRAY_STORAGE);
    }

    @Override
    AbstractStorage getOverflowStorage() {
        return StorageFactory.createStorage(StorageFactory.StorageType.SORTED_ARRAY_STORAGE);
    }
}
