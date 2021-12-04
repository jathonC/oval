package com.epam.oval.logic;

import com.epam.oval.datareader.DataException;
import com.epam.oval.datareader.DataReader;
import com.epam.oval.entity.Oval;

import java.util.ArrayList;
import java.util.List;

public class Director {
    final private DataReader reader;
    final private OvalValidator validator;
    final private OvalCreator creator;

    public Director(DataReader reader, OvalValidator validator, OvalCreator creator) {
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Oval> read(String path) throws DataException{
         List<Oval> ovals = new ArrayList<>();
        for (String line: reader.read(path)){
            if(validator.isValidLine(line)){
                Oval oval =creator.create(line);
                ovals.add(oval);
            }
        }
        return ovals;
    }
}
