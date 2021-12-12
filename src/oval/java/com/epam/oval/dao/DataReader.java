package com.epam.oval.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.epam.oval.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataReader {

    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public List<String> read(String path) throws DataException {
        LOGGER.info("Start reading data from " + path);
        List<String> data = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line = bufferedReader.readLine();
            while (line != null) {
                data.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            DataException dataException = new DataException(e.getMessage(), e);
            LOGGER.throwing(dataException);
            throw new DataException("Could not find file", e);
        } catch (IOException e) {
            DataException dataException = new DataException(e.getMessage(), e);
            LOGGER.throwing(dataException);
            throw new DataException("An IO error occured", e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                LOGGER.warn(e.getMessage(), e);
                //Logger.warn(e.getMessage() e) прикрутить
            }
        }
        return data;
    }
}
