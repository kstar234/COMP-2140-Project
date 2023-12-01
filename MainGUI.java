import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainGUI {
    private static final int LOCATION_OPTIONS = 4;
    private static final int DEPARTURE_TIME_OPTIONS = 6;

    private int currentQuestionIndex = 0;
    private int[] locationCounts = new int[LOCATION_OPTIONS];
    private int[] departureTimeCounts = new int[DEPARTURE_TIME_OPTIONS];

    private String[] locationQuestions = {"Which locations will you frequently travel to for the semester?",
            "1. Kingston", "2. Spanish Town", "3. Portmore", "4. Other"};
    private String[] departureTimeQuestions = {"What times will you depart each day for the week?",
            "1. 6-7AM", "2. 7-8AM", "3. 8-9AM", "4. 9-10AM", "5. 10-11AM", "6. 11AM+"};

    private static final String DATA_FILE_PATH = "poll_data.txt";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                MainGUI mainGUI = new MainGUI();
                mainGUI.loadData();
                mainGUI.initialize();
                mainGUI.addShutdownHook();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            saveData();
            System.out.println("Data saved. Exiting program.");
        }));
    }

    private void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    int index = Integer.parseInt(parts[0].trim()) - 1;
                    int count = Integer.parseInt(parts[1].trim());
                    if (index >= 0 && index < LOCATION_OPTIONS) {
                        locationCounts[index] = count;
                    } else if (index >= 0 && index < DEPARTURE_TIME_OPTIONS) {
                        departureTimeCounts[index] = count;
                    }
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data. Starting with fresh data.");
        }
    }

    private void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH))) {
            for (int i = 0; i < LOCATION_OPTIONS; i++) {
                writer.write((i + 1) + ": " + locationCounts[i]);
                writer.newLine();
            }
            for (int i = 0; i < DEPARTURE_TIME_OPTIONS; i++) {
                writer.write((i + 1) + ": " + departureTimeCounts[i]);
                writer.newLine();
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        showLoginPage();
    }

    private void showLoginPage() {
        String[] options = {"Admin", "Student"};
        int choice = JOptionPane.showOptionDialog(null, "Select User Type", "Login",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            // Admin selected
            showAdminMenu();
        } else if (choice == 1) {
            // Student selected
            showStudentMenu();
        } else {
            // User closed the dialog or an error occurred
            System.exit(0);
        }
    }

    private void showAdminMenu() {
        String[] adminOptions = {"Go to Poll", "See Responses", "Generate Report", "Exit"};
        int choice = JOptionPane.showOptionDialog(null, "Admin Menu", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, adminOptions, adminOptions[0]);

        switch (choice) {
            case 0:
                runCombinedPoll();
                break;
            case 1:
                seeResponses();
                break;
            case 2:
                generateReport();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                // User closed the dialog or an error occurred
                System.exit(0);
        }
    }

    private void showStudentMenu() {
        String[] studentOptions = {"Go to Poll", "Exit"};
        int choice = JOptionPane.showOptionDialog(null, "Student Menu", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, studentOptions, studentOptions[0]);

        switch (choice) {
            case 0:
                runCombinedPoll();
                break;
            case 1:
                System.exit(0);
                break;
            default:
                // User closed the dialog or an error occurred
                System.exit(0);
        }
    }

    private void runCombinedPoll() {
        showLocationPollQuestion();
    }

    private void showLocationPollQuestion() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel(locationQuestions[0]));

        ButtonGroup group = new ButtonGroup();
        for (int i = 1; i < locationQuestions.length; i++) {
            JRadioButton radioButton = new JRadioButton(locationQuestions[i]);
            final int index = i - 1;
            radioButton.addActionListener(e -> recordLocationResponse(index));
            group.add(radioButton);
            panel.add(radioButton);
        }

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> showDepartureTimesPollQuestion());
        panel.add(nextButton);

        showPollPage(panel);
    }

    private void showDepartureTimesPollQuestion() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel(departureTimeQuestions[0]));

        ButtonGroup group = new ButtonGroup();
        for (int i = 1; i < departureTimeQuestions.length; i++) {
            JRadioButton radioButton = new JRadioButton(departureTimeQuestions[i]);
            final int index = i - 1;
            radioButton.addActionListener(e -> recordDepartureTimeResponse(index));
            group.add(radioButton);
            panel.add(radioButton);
        }

        JButton finishButton = new JButton("Finish");
        finishButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Thank you for answering!\n");
            // Additional logic or actions can be added here
        });
        JButton returnButton = new JButton("Return to Main Menu");
        returnButton.addActionListener(e -> showAdminMenu());
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(finishButton);
        panel.add(returnButton);
        panel.add(exitButton);

        showPollPage(panel);
    }

    private void showPollPage(JPanel panel) {
        JFrame frame = new JFrame("Poll Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void seeResponses() {
        JOptionPane.showMessageDialog(null, getResponsesText(), "See Responses for Combined Poll", JOptionPane.INFORMATION_MESSAGE);
    }

    private String getResponsesText() {
        StringBuilder responseStringBuilder = new StringBuilder();

        responseStringBuilder.append("\nSee Responses for Locations:");

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

            responseStringBuilder.append(optionLabel).append(": ").append(locationCounts[i]).append(" responses\n");
        }

        responseStringBuilder.append("\nSee Responses for Departure Times:");

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

            responseStringBuilder.append(optionLabel).append(": ").append(departureTimeCounts[i]).append(" responses\n");
        }

        return responseStringBuilder.toString();
    }

    private void recordLocationResponse(int optionIndex) {
        // Increment the count for the selected location option
        if (optionIndex >= 0 && optionIndex < LOCATION_OPTIONS) {
            locationCounts[optionIndex]++;
        } else {
            System.out.println("Invalid option. Response not recorded.");
        }
    }

    private void recordDepartureTimeResponse(int optionIndex) {
        // Increment the count for the selected departure time option
        if (optionIndex >= 0 && optionIndex < DEPARTURE_TIME_OPTIONS) {
            departureTimeCounts[optionIndex]++;
        } else {
            System.out.println("Invalid option. Response not recorded.");
        }
    }

    private void generateReport() {
        StringBuilder reportStringBuilder = new StringBuilder("Generate Report:");

        reportStringBuilder.append("\n\nGenerate Report for Locations:");
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
            reportStringBuilder.append("\n").append(optionLabel).append(": ").append(percentage).append("%");
        }

        reportStringBuilder.append("\n\nGenerate Report for Departure Times:");
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
            reportStringBuilder.append("\n").append(optionLabel).append(": ").append(percentage).append("%");
        }

        JOptionPane.showMessageDialog(null, reportStringBuilder.toString());
    }

    private int getTotalResponses(int[] counts) {
        int total = 0;
        for (int count : counts) {
            total += count;
        }
        return total;
    }

    private double calculatePercentage(int count, int total) {
        if (total == 0) {
            return 0.0;
        }
        return ((double) count / total) * 100;
    }
}
