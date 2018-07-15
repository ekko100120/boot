package com.mercury.upload.Storage;

public class FileNoteFoundException extends StorageException {
    public FileNoteFoundException(String message) {
        super(message);
    }

    public FileNoteFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
