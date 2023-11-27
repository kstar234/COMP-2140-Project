import java.util.ArrayList;
import java.util.List;

public class Poll {
    private List<Question> questions;
    private List<String> responses;

    public Poll() {
        this.questions = new ArrayList<>();
        this.responses = new ArrayList<>();
    }

    // Class methods

    // Add a question to the poll
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Delete a question from the poll
    public void deleteQuestion(Question question) {
        questions.remove(question);
    }

    // Display all questions in the poll
    public void displayQuestions() {
        for (Question question : questions) {
            System.out.println(question.getText());
        }
    }

    // Record a response to the poll
    public void recordResponse(String response) {
        responses.add(response);
    }

    // Display all responses to the poll
    public void displayResponses() {
        for (String response : responses) {
            System.out.println(response);
        }
    }

    // Inner class representing a question
    public static class Question {
        private String text;

        public Question(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
