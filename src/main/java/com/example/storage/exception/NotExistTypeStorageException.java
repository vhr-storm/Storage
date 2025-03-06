package com.example.storage.exception;

public class NotExistTypeStorageException extends StorageException {
    public NotExistTypeStorageException(String type) {
        super("Unknown storage type" + type);
    }
}
