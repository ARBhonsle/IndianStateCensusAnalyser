package com.analyser;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for simple CensusAnalyser.
 */
public class CensusAnalyserTest {
    private static final String INDIA_CENSUS_FILE_PATH = "src/resources/IndianStateCensus.csv";
    private static final String INDIA_CENSUS_WRONG_FILE_PATH = "main/resources/IndianStateCensus.csv";

    @Test
    public void givenIndianStateCSV_ShouldReturnExactCount() throws Exception {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndianCensusData(INDIA_CENSUS_FILE_PATH);
            Assert.assertEquals(30, numOfRecords);
        } catch (CensusAnalyserException e) {
            throw new Exception(e);
        }
    }

    @Test
    public void givenIndianStateCSV_ShouldThrowException(){
        try{
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exception = ExpectedException.none();
            exception.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndianCensusData(INDIA_CENSUS_WRONG_FILE_PATH);
        } catch (CensusAnalyserException e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

}
