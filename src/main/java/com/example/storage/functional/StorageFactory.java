package com.example.storage.functional;

import com.example.storage.exception.NotExistTypeStorageException;
import org.springframework.stereotype.Component;

@Component
public class StorageFactory {
    public enum StorageType {
        SORTED_ARRAY_STORAGE,
        ARRAY_STORAGE,
        MAP_UUID_STORAGE,
        LIST_STORAGE,
        MAP_RESUME_STORAGE,
        NO_TYPE
    }

    public static AbstractStorage createStorage(StorageType type) {
        AbstractStorage typeStorage = null;
        switch (type) {
            case ARRAY_STORAGE -> typeStorage = new ArrayStorage();
            case SORTED_ARRAY_STORAGE -> typeStorage = new SortedArrayStorage();
            case MAP_UUID_STORAGE -> typeStorage = new MapUuidStorage();
            case LIST_STORAGE -> typeStorage = new ListStorage();
            case MAP_RESUME_STORAGE -> typeStorage = new MapResumeStorage();
            default -> throw new NotExistTypeStorageException(type.toString());
        }
        return typeStorage;
    }
}
