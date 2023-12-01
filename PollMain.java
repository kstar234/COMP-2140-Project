import java.util.Scanner;

public class PollMain {
    private static final int LOCATION_OPTIONS = 4;
    private static final int DEPARTURE_TIME_OPTIONS = 6;

    private static int[] locationCounts = new int[LOCATION_OPTIONS];
    private static int[] departureTimeCounts = new int[DEPARTURE_TIME_OPTIONS];

    public static void main(String[] args) {
        PollUser loggedInUser = LoginService.loginUser();

        // Check if login was successful
        if (loggedInUser != null) {
            System.out.println("Welcome, " + loggedInUser.getUsername() + "!\n");

            // Display menu options based on user type
            mainMenu(loggedInUser);
        } else {
            System.out.println("Exiting program.");
        }
    }

    private static void mainMenu(PollUser loggedInUser) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Go to Poll");

            // Display additional options for admin
            if (loggedInUser.getUserType() == UserType.ADMIN) {
                System.out.println("2. See Responses");
                System.out.println("3. Generate Report");
            }

            System.out.println("4. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    runCombinedPoll();
                    break;
                case 2:
                    // Check if the user is admin before allowing access
                    if (loggedInUser.getUserType() == UserType.ADMIN) {
                        seeResponses();
                    } else {
                        System.out.println("You do not have permission to access this option.\n");
                    }
                    break;
                case 3:
                    // Check if the user is admin before allowing access
                    if (loggedInUser.getUserType() == UserType.ADMIN) {
                        generateReport();
                    } else {
                        System.out.println("You do not have permission to access this option.\n");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }


    private static void runCombinedPoll() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Combined Poll:");
        askLocationsPollQuestion();
        askDepartureTimesPollQuestion();

        System.out.println("Thank you for answering!\n");
    }

    private static void askLocationsPollQuestion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Locations Poll Question:");
        System.out.println("Which locations will you frequently travel to for the semester?");
        System.out.println("1. Kingston");
        System.out.println("2. Spanish Town");
        System.out.println("3. Portmore");
        System.out.println("4. Other");

        int selectedOption = scanner.nextInt();
        recordLocationResponse(selectedOption);
    }

    private static void askDepartureTimesPollQuestion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Departure Times Poll Question:");
        System.out.println("What times will you depart each day for the week?");
        System.out.println("1. 6-7AM");
        System.out.println("2. 7-8AM");
        System.out.println("3. 8-9AM");
        System.out.println("4. 9-10AM");
        System.out.println("5. 10-11AM");
        System.out.println("6. 11AM+");

        int selectedOption = scanner.nextInt();
        recordDepartureTimeResponse(selectedOption);
    }

    private static void recordLocationResponse(int option) {
        // Increment the count for the selected location option
        if (option >= 1 && option <= LOCATION_OPTIONS) {
            locationCounts[option - 1]++;
        } else {
            System.out.println("Invalid option. Response not recorded.");
        }
    }

    private static void recordDepartureTimeResponse(int option) {
        // Increment the count for the selected departure time option
        if (option >= 1 && option <= DEPARTURE_TIME_OPTIONS) {
            departureTimeCounts[option - 1]++;
        } else {
            System.out.println("Invalid option. Response not recorded.");
        }
    }

    private static void seeResponses() {
        System.out.println("See Responses for Combined Poll:");

        System.out.println("\nSee Responses for Locations:");

        for (int i = 0; i < LOCATION_OPTIONS; i++) {
            String optionLabel;
            switch (i + 1) {
                case 1:
                    optionLabel = "Kingston";
                    break;
                case 2:
                    optionLabel = "Spanish Town";
                    break;
                case 3:
                    optionLabel = "Portmore";
                    break;
                case 4:
                    optionLabel = "Other";
                    break;
                default:
                    optionLabel = "Invalid Option";
            }

            System.out.println(optionLabel + ": " + locationCounts[i] + " responses");
        }

        System.out.println("\nSee Responses for Departure Times:");

        for (int i = 0; i < DEPARTURE_TIME_OPTIONS; i++) {
            String optionLabel;
            switch (i + 1) {
                case 1:
                    optionLabel = "6-7AM";
                    break;
                case 2:
                    optionLabel = "7-8AM";
                    break;
                case 3:
                    optionLabel = "8-9AM";
                    break;
                case 4:
                    optionLabel = "9-10AM";
                    break;
                case 5:
                    optionLabel = "10-11AM";
                    break;
                case 6:
                    optionLabel = "11AM+";
                    break;
                default:
                    optionLabel = "Invalid Option";
            }

            System.out.println(optionLabel + ": " + departureTimeCounts[i] + " responses");
        }

        System.out.println();
    }

    private static void generateReport() {
        System.out.println("Generate Report for Combined Poll:");

        generateLocationReport();
        generateDepartureTimeReport();
    }

    private static void generateLocationReport() {
        System.out.println("\nGenerate Report for Locations:");

        int totalLocationResponses = getTotalResponses(locationCounts);

        for (int i = 0; i < LOCATION_OPTIONS; i++) {
            String optionLabel;
            switch (i + 1) {
                case 1:
                    optionLabel = "Kingston";
                    break;
                case 2:
                    optionLabel = "Spanish Town";
                    break;
                case 3:
                    optionLabel = "Portmore";
                    break;
                case 4:
                    optionLabel = "Other";
                    break;
                default:
                    optionLabel = "Invalid Option";
            }

            double percentage = calculatePercentage(locationCounts[i], totalLocationResponses);
            System.out.println(optionLabel + ": " + percentage + "%");
        }
    }

    private static void generateDepartureTimeReport() {
        System.out.println("\nGenerate Report for Departure Times:");

        int totalDepartureTimeResponses = getTotalResponses(departureTimeCounts);

        for (int i = 0; i < DEPARTURE_TIME_OPTIONS; i++) {
            String optionLabel;
            switch (i + 1) {
                case 1:
                    optionLabel = "6-7AM";
                    break;
                case 2:
                    optionLabel = "7-8AM";
                    break;
                case 3:
                    optionLabel = "8-9AM";
                    break;
                case 4:
                    optionLabel = "9-10AM";
                    break;
                case 5:
                    optionLabel = "10-11AM";
                    break;
                case 6:
                    optionLabel = "11AM+";
                    break;
                default:
                    optionLabel = "Invalid Option";
            }

            double percentage = calculatePercentage(departureTimeCounts[i], totalDepartureTimeResponses);
            System.out.println(optionLabel + ": " + percentage + "%");
        }
    }

    private static int getTotalResponses(int[] counts) {
        int total = 0;
        for (int count : counts) {
            total += count;
        }
        return total;
    }

    private static double calculatePercentage(int count, int total) {
        if (total == 0) {
            return 0.0;
        }
        return ((double) count / total) * 100;
    }
}
