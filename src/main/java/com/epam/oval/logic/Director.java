package com.epam.oval.logic;

import com.epam.oval.dao.DataException;
import com.epam.oval.dao.DataReader;
import com.epam.oval.entity.Oval;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Director {

    private final static Logger LOGGER = LogManager.getLogger(Director.class);
    private final DataReader reader;
    private final OvalValidator validator;
    private final OvalCreator creator;

    public Director(DataReader reader, OvalValidator validator, OvalCreator creator) {
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Oval> read(String path) throws DataException {
        LOGGER.info("Started reading ovals from file: " + path);
        List<Oval> ovals = new ArrayList<>();
        for (String line : reader.read(path)) {
            if (validator.isValidLine(line)) {
                Oval oval = creator.create(line);
                ovals.add(oval);
            }
        }
        return ovals;
    }
}
