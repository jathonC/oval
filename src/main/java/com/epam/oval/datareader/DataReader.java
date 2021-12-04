package com.epam.oval.datareader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class DataReader {

    public List<String> read(String path) throws DataException {
        List<String> data = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = bufferedReader.readLine();
            while (line != null) {
                data.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new DataException("Could not not find file",e);
        } catch (IOException e) {
            throw new DataException("An IO error occured",e);
        }
        return data;
    }
}
