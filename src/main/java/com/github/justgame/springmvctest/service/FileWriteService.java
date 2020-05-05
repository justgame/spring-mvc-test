package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.integration.FileWriterGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XieCl
 * @date 2020/5/5 17:22
 */
@Service
public class FileWriteService {
    @Autowired
    private FileWriterGateway fileWriterGateway;

    public void write(String data) {
        fileWriterGateway.writeToFile("text.txt", data);
    }
}
