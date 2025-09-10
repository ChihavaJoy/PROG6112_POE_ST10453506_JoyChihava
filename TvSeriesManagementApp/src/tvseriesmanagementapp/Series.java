/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tvseriesmanagementapp;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author lab_services_student
 */
public class Series {
    
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int numberOfEpisodes;
    public Scanner Scanner;
    

   // Constructor
    public Series(String seriesId, String seriesName, int seriesAge, int numberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.numberOfEpisodes = numberOfEpisodes;
    }

    // Getters and setters
    public String getSeriesId() { return seriesId; }
    public void setSeriesId(String seriesId) { this.seriesId = seriesId; }

    public String getSeriesName() { return seriesName; }
    public void setSeriesName(String seriesName) { this.seriesName = seriesName; }

    public int getSeriesAge() { return seriesAge; }
    public void setSeriesAge(int seriesAge) { this.seriesAge = seriesAge; }

    public int getNumberOfEpisodes() { return numberOfEpisodes; }
    public void setNumberOfEpisodes(int numberOfEpisodes) { this.numberOfEpisodes = numberOfEpisodes; }

    @Override
    public String toString() {
        return "SERIES ID: " + seriesId + "\n" +
               "SERIES NAME: " + seriesName + "\n" +
               "SERIES AGE RESTRICTION: " + seriesAge + "\n" +
               "NUMBER OF EPISODES: " + numberOfEpisodes;
    }

    // Methods

    public static boolean captureSeries(List<Series> seriesList, String id, String name, int age, int episodes) {
    // Add the new series to the list
    seriesList.add(new Series(id.trim(), name.trim(), age, episodes));
    return true;
}


    public static Series searchSeries(List<Series> seriesList, String searchId) {
        for (Series s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(searchId)) {
                return s;
            }
        }
        return null;
    }

    public static void updateSeries(Series target, String newName, int newAge, int newEpisodes) {
        if (!newName.isEmpty()) target.setSeriesName(newName);
        target.setSeriesAge(newAge);
        target.setNumberOfEpisodes(newEpisodes);
    }

    public static void deleteSeries(List<Series> seriesList, Series target) {
        seriesList.remove(target);
    }

    public static void seriesReport(List<Series> seriesList) {
        System.out.println("\n=== SERIES REPORT - 2025 ===");

        if (seriesList.isEmpty()) {
            System.out.println("No series have been captured yet.");
            return;
        }

        int count = 1;
        for (Series s : seriesList) {
            System.out.println("Series " + count);
            System.out.println(s);
            System.out.println();
            count++;
        }
    }
    
    public static void exitSeriesApplication(Scanner scanner) {
    System.out.println("\nExit Application. Goodbye!");
    scanner.close();
    System.exit(0);
}
    public static boolean isValidAgeRestriction(int age) {
        return age >= 2 && age <= 18;
    }
}

