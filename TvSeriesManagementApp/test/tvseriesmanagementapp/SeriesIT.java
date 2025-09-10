/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tvseriesmanagementapp;

import org.junit.Before;
import org.junit.Test;
import tvseriesmanagementapp.Series;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author lab_services_student
 */
public class SeriesIT {
    
    private List<Series> seriesList;

    @Before
    public void setUp() {
        seriesList = new ArrayList<>();
        // Add a sample series for testing
        Series.captureSeries(seriesList, "S01", "Stranger Things", 16, 40);
    }
    
    public SeriesIT() {
    }

   
    @Test
    public void testSearchSeries() {
        Series found = Series.searchSeries(seriesList, "S01");
        assertNotNull(found);
        assertEquals("Stranger Things", found.getSeriesName());
        assertEquals(16, found.getSeriesAge());
        assertEquals(40, found.getNumberOfEpisodes());
    }
    
    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series found = Series.searchSeries(seriesList, "S99");
        assertNull(found);
    }

    @Test
    public void testUpdateSeries() {
        Series target = Series.searchSeries(seriesList, "S01");
        Series.updateSeries(target, "Stranger Things Updated", 18, 50);

        assertEquals("Stranger Things Updated", target.getSeriesName());
        assertEquals(18, target.getSeriesAge());
        assertEquals(50, target.getNumberOfEpisodes());
    }

    @Test
    public void testDeleteSeries() {
        Series target = Series.searchSeries(seriesList, "S01");
        Series.deleteSeries(seriesList, target);

        assertNull(Series.searchSeries(seriesList, "S01"));
        assertTrue(seriesList.isEmpty());
    }
    
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        Series target = Series.searchSeries(seriesList, "S99");
        // Deleting null should not affect the list
        if (target != null) {
            Series.deleteSeries(seriesList, target);
        }
        assertEquals(1, seriesList.size());
    }
    
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        // Test ages within the valid range
        assertTrue(Series.isValidAgeRestriction(2));
        assertTrue(Series.isValidAgeRestriction(10));
        assertTrue(Series.isValidAgeRestriction(18));
    }
    
    @Test
    public void TestSeriesAgeRestriction_AgeInValid() {
        // Test ages outside the valid range
        assertFalse(Series.isValidAgeRestriction(1));
        assertFalse(Series.isValidAgeRestriction(0));
        assertFalse(Series.isValidAgeRestriction(19));
        assertFalse(Series.isValidAgeRestriction(100));
        assertFalse(Series.isValidAgeRestriction(-5));
    }

    @Test
    public void testSeriesReport() {
    }

    @Test
    public void testExitSeriesApplication() {
    }
    
}
