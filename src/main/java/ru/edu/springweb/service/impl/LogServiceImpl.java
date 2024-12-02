package ru.edu.springweb.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.edu.springweb.service.LogService;


@Service
public class LogServiceImpl implements LogService {

    private final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Override
    public void logInfo(String message) {
        logger.info(message);
    }

    @Override
    public void logWarn(String message) {
        logger.warn(message);
    }

    @Override
    public void logError(String message) {
        logger.error(message);
    }
}
