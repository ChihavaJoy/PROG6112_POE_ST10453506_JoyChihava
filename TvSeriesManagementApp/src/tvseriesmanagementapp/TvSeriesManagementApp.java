/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tvseriesmanagementapp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author lab_services_student
 */
public class TvSeriesManagementApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner scanner = new Scanner(System.in);
        List<Series> seriesList = new ArrayList<>();

        while (true) {
            System.out.println("\nLATEST SERIES - 2025");
            System.out.println("**********************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String input = scanner.nextLine().trim();
            if (!input.equals("1")) {
                Series.exitSeriesApplication(scanner);
            }

            
            showMenu();

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    captureSeriesMenu(seriesList, scanner);
                    break;
                case "2":
                    searchSeriesMenu(seriesList, scanner);
                    break;
                case "3":
                    updateSeriesMenu(seriesList, scanner);
                    break;
                case "4":
                    deleteSeriesMenu(seriesList, scanner);
                    break;
                case "5":
                    Series.seriesReport(seriesList);
                    break;
                case "6":
                    exitSeriesApplication(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }
        } 
       
    }
    
 
    private static void showMenu() {
        System.out.println("\nPlease select one of the following menu items:");
        System.out.println("1. Capture a new series");
        System.out.println("2. Search for a series");
        System.out.println("3. Update series age restriction");
        System.out.println("4. Delete a series");
        System.out.println("5. Print series report - 2025");
        System.out.println("6. Exit Application");
        System.out.print("Enter your choice: ");
    }
    
     // MENU HANDLERS (these use Scanner for input)

   private static void captureSeriesMenu(List<Series> seriesList, Scanner scanner) {
    System.out.println("\nCAPTURE A NEW SERIES");
    System.out.println("**********************************************");

    // Get unique series ID
    String id;
    while (true) {
        System.out.print("Enter the series id: ");
        id = scanner.nextLine().trim();

        boolean duplicate = false;
        for (Series s : seriesList) {
            if (s.getSeriesId().trim().equalsIgnoreCase(id)) {
                duplicate = true;
                break;
            }
        }

        if (duplicate) {
            System.out.println("A series with ID " + id + " already exists! Please enter a different ID.");
        } else {
            break; // unique ID
        }
    }

    // Get series name
    System.out.print("Enter the series name: ");
    String name = scanner.nextLine().trim();

    // Get valid age restriction
    int age = 0;
    while (true) {
        System.out.print("Enter the series age restriction: ");
        String ageInput = scanner.nextLine().trim();
        try {
            age = Integer.parseInt(ageInput);
            if (Series.isValidAgeRestriction(age)) {
                break;
            } else {
                System.out.println("You have entered an incorrect series age!!! Please re-enter.");
            }
        } catch (NumberFormatException e) {
            System.out.println("You have entered an incorrect series age!!! Please re-enter.");
        }
    }

    // Get number of episodes
    int episodes = 0;
    while (true) {
        System.out.print("Enter the number of episodes for " + name + ": ");
        String epInput = scanner.nextLine().trim();
        try {
            episodes = Integer.parseInt(epInput);
            break;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Please enter a numeric value.");
        }
    }

    // Store series using Series.captureSeries
    Series.captureSeries(seriesList, id, name, age, episodes);
    System.out.println("Series processed successfully!!!");
}



    private static void searchSeriesMenu(List<Series> seriesList, Scanner scanner) {
        System.out.print("Enter the Series ID to search: ");
        String searchId = scanner.nextLine().trim();

        Series found = Series.searchSeries(seriesList, searchId);
        if (found != null) {
            System.out.println("\nSeries found:");
            System.out.println(found);
        } else {
            System.out.println("Series with Series Id: " + searchId + " was not found!");
        }
    }

    private static void updateSeriesMenu(List<Series> seriesList, Scanner scanner) {
        System.out.print("Enter the series id to update: ");
        String updateId = scanner.nextLine().trim();

        Series target = Series.searchSeries(seriesList, updateId);
        if (target == null) {
            System.out.println("Series with Series Id: " + updateId + " was not found!");
            return;
        }

        System.out.print("Enter the new series name: ");
        String newName = scanner.nextLine().trim();

        int newAge;
        while (true) {
            System.out.print("Enter the new age restriction: ");
            String ageInput = scanner.nextLine().trim();
            try {
                newAge = Integer.parseInt(ageInput);
                if (newAge >= 2 && newAge <= 18) break;
                else System.out.println("You have entered an incorrect series age!!! Please re-enter.");
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect series age!!! Please re-enter.");
            }
        }

        int newEpisodes;
        while (true) {
            System.out.print("Enter the number of episodes: ");
            String epInput = scanner.nextLine().trim();
            try {
                newEpisodes = Integer.parseInt(epInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a numeric value.");
            }
        }

        Series.updateSeries(target, newName, newAge, newEpisodes);
        System.out.println("Series updated successfully!!!");
    }

    private static void deleteSeriesMenu(List<Series> seriesList, Scanner scanner) {
        System.out.print("Enter the series id to delete: ");
        String deleteId = scanner.nextLine().trim();

        Series target = Series.searchSeries(seriesList, deleteId);
        if (target == null) {
            System.out.println("Series with Series Id: " + deleteId + " was not found!");
            return;
        }

        System.out.print("Are you sure you want to delete series " + deleteId + " from the system? Yes (y) to delete: ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
            Series.deleteSeries(seriesList, target);
            System.out.println("Series with Series Id: " + deleteId + " WAS deleted!");
        } else {
            System.out.println("Delete cancelled. Series " + deleteId + " was NOT deleted.");
        }
    }

    private static void exitSeriesApplication(Scanner scanner) {
        System.out.println("\nExit Application. Goodbye!");
        scanner.close();
        System.exit(0);
    }

    
}
