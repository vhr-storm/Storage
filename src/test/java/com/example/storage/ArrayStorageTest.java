package com.example.storage;

import com.example.storage.functional.AbstractStorage;
import com.example.storage.functional.StorageFactory;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    static final AbstractStorage TEST_ARRAY_STORAGE =
            StorageFactory.createStorage(StorageFactory.StorageType.ARRAY_STORAGE);
    static final AbstractStorage TEST_ARRAY_OVERFLOW_STORAGE =
            StorageFactory.createStorage(StorageFactory.StorageType.ARRAY_STORAGE);

    @Override
    AbstractStorage getStorage() {
        return TEST_ARRAY_STORAGE;
    }

    @Override
    AbstractStorage getOverflowStorage() {
        return TEST_ARRAY_OVERFLOW_STORAGE;
    }
}
