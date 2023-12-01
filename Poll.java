import java.util.Scanner;

public class Poll {
    private static final int LOCATION_OPTIONS = 4;
    private static final int DEPARTURE_TIME_OPTIONS = 6;

    private int[] locationCounts = new int[LOCATION_OPTIONS];
    private int[] departureTimeCounts = new int[DEPARTURE_TIME_OPTIONS];

    public void conductCombinedPoll() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Combined Poll:");
        askLocationsPollQuestion();
        askDepartureTimesPollQuestion();

        System.out.println("Thank you for answering!\n");
    }

    private void askLocationsPollQuestion() {
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

    private void askDepartureTimesPollQuestion() {
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

    private void recordLocationResponse(int option) {
        // Increment the count for the selected location option
        if (option >= 1 && option <= LOCATION_OPTIONS) {
            locationCounts[option - 1]++;
        } else {
            System.out.println("Invalid option. Response not recorded.");
        }
    }

    private void recordDepartureTimeResponse(int option) {
        // Increment the count for the selected departure time option
        if (option >= 1 && option <= DEPARTURE_TIME_OPTIONS) {
            departureTimeCounts[option - 1]++;
        } else {
            System.out.println("Invalid option. Response not recorded.");
        }
    }

    public void printPollResults() {
        // Print poll results as needed
        // This could be similar to the seeResponses and generateReport methods in your existing code
        // Use the locationCounts and departureTimeCounts arrays to display responses
    }
}
