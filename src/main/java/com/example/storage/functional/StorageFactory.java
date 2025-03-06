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

        switch (type) {
            case ARRAY_STORAGE -> {
                return new ArrayStorage();
            }
            case SORTED_ARRAY_STORAGE -> {
                return new SortedArrayStorage();
            }
            case MAP_UUID_STORAGE -> {
                return new MapUuidStorage();
            }
            case LIST_STORAGE -> {
                return new ListStorage();
            }
            case MAP_RESUME_STORAGE -> {
                return new MapResumeStorage();
            }
            default -> throw new NotExistTypeStorageException(type.toString());
        }
    }
}
