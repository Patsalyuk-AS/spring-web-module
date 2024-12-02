package ru.edu.springweb.service;

public interface LogService {

    void logInfo(String message);
    void logWarn(String message);
    void logError(String message);
}
