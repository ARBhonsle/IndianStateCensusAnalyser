package com.analyser;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

/**
 * Indian State Census Analyser
 */
public class CensusAnalyser {

    public static int loadIndianCensusData(String filePath) throws CensusAnalyserException {
        int count = 0;
        try {
            FileReader filereader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                count++;
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (IllegalStateException e) {
            new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Indian State Census Analyser!");
    }
}
