import java.util.Scanner;

// ─────────────────────────────────────────────────────────────
//  CUSTOMER FEEDBACK ANALYSIS SYSTEM
//  Course  : Object Oriented Programming with Java
//  College : Rungta International Skills University, Bhilai
//  Author  : Divyansh | Guide: Mr. Soumik Karmakar
// ─────────────────────────────────────────────────────────────


// ─── Feedback Class ───────────────────────────────────────────
// This class represents a single customer feedback entry.
// It stores the rating score and the comment given by the customer.
// Encapsulation is used — fields are private, accessed via getters.

class Feedback {

    private int score;       // Rating given by customer (1 to 5)
    private String comment;  // Written comment by customer

    // Constructor — called when a new Feedback object is created
    public Feedback(int score, String comment) {
        this.score   = score;
        this.comment = comment;
    }

    // Getter for score — returns the rating
    public int getScore() {
        return score;
    }

    // Getter for comment — returns the written feedback
    public String getComment() {
        return comment;
    }

    // Displays a single feedback entry in formatted output
    public void display() {
        System.out.println("  Score: " + score + " | Comment: " + comment);
    }
}


// ─── Analyzer Class ───────────────────────────────────────────
// This class handles all the business logic.
// It takes an array of Feedback objects and:
//   1. Calculates the average rating
//   2. Classifies sentiment using switch-case
//   3. Prints a breakdown of how many ratings fall in each category

class Analyzer {

    private Feedback[] feedbacks;  // Array holding all feedback entries

    // Constructor — receives the feedback array from Main
    public Analyzer(Feedback[] feedbacks) {
        this.feedbacks = feedbacks;
    }

    // Calculates and returns the average score of all feedbacks
    public double calculateAverage() {
        int total = 0;

        // Loop through each feedback and add up all scores
        for (Feedback f : feedbacks) {
            total += f.getScore();
        }

        // Divide total by number of entries to get average
        // Cast to double to avoid integer division
        return (double) total / feedbacks.length;
    }

    // Classifies the sentiment based on the average rating
    // Math.round() is used to round the average to nearest integer
    // Switch-case maps the rounded value to a sentiment category
    public String categorizeSentiment(double avg) {
        int rounded = (int) Math.round(avg);

        switch (rounded) {
            case 5:
                return "Excellent";  // Average is 5 → best category
            case 4:
                return "Good";       // Average is 4 → good feedback
            case 3:
                return "Average";    // Average is 3 → neutral feedback
            case 1:
            case 2:
                return "Poor";       // Average is 1 or 2 → bad feedback
            default:
                return "Unknown";    // Safety fallback (should not occur)
        }
    }

    // Counts and prints how many entries fall into each rating category
    public void printBreakdown() {

        // Individual counters for each category
        int excellent = 0;
        int good      = 0;
        int average   = 0;
        int poor      = 0;

        // Loop through each feedback and increment the right counter
        for (Feedback f : feedbacks) {
            switch (f.getScore()) {
                case 5: excellent++; break;  // Score 5 → Excellent
                case 4: good++;      break;  // Score 4 → Good
                case 3: average++;   break;  // Score 3 → Average
                default: poor++;             // Score 1 or 2 → Poor
            }
        }

        // Print the final breakdown
        System.out.println("  Excellent (5) : " + excellent);
        System.out.println("  Good      (4) : " + good);
        System.out.println("  Average   (3) : " + average);
        System.out.println("  Poor    (1-2) : " + poor);
    }
}


// ─── Main Class ───────────────────────────────────────────────
// This is the entry point of the program.
// It handles:
//   - Taking user input (number of entries, scores, comments)
//   - Input validation (score must be between 1 and 5)
//   - Creating Feedback objects and storing them in an array
//   - Passing the array to Analyzer and displaying results

public class Main {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Display welcome header
        System.out.println("======================================");
        System.out.println("  Customer Feedback Analysis System");
        System.out.println("======================================");

        // Ask user how many feedback entries they want to enter
        System.out.print("How many feedback entries? ");
        int n = sc.nextInt();
        sc.nextLine(); // Flush the leftover newline after nextInt()

        // Create an array to hold all Feedback objects
        Feedback[] feedbacks = new Feedback[n];

        // Loop to collect each feedback entry one by one
        for (int i = 0; i < n; i++) {

            System.out.println("\n--- Entry " + (i + 1) + " of " + n + " ---");

            // Input validation loop — keeps asking until valid score is given
            int score = 0;
            while (score < 1 || score > 5) {
                System.out.print("  Rating (1-5): ");
                score = sc.nextInt();
                sc.nextLine(); // Flush newline after each nextInt()

                // Show error if score is out of valid range
                if (score < 1 || score > 5) {
                    System.out.println("  Invalid! Please enter a value between 1 and 5.");
                }
            }

            // Read the written comment from the customer
            System.out.print("  Comment: ");
            String comment = sc.nextLine();

            // Create a new Feedback object and store it in the array
            feedbacks[i] = new Feedback(score, comment);
        }

        // ── Analysis ──────────────────────────────────────────
        // Create Analyzer object and pass the feedbacks array to it
        Analyzer analyzer = new Analyzer(feedbacks);

        // Calculate the average rating
        double avg = analyzer.calculateAverage();

        // Get the sentiment category based on average
        String sentiment = analyzer.categorizeSentiment(avg);

        // ── Output ────────────────────────────────────────────
        System.out.println("\n======================================");
        System.out.println("              RESULTS");
        System.out.println("======================================");

        // Print all feedback entries using Feedback's display() method
        System.out.println("\nAll Feedback Entries:");
        System.out.println("----------------------------------------");
        for (Feedback f : feedbacks) {
            f.display();
        }

        // Print average rating formatted to 2 decimal places
        System.out.println("----------------------------------------");
        System.out.printf("Average Rating  : %.2f / 5.00%n", avg);

        // Print the sentiment category
        System.out.println("Sentiment       : " + sentiment);

        // Print the score breakdown using Analyzer's method
        System.out.println("\nScore Breakdown:");
        analyzer.printBreakdown();

        System.out.println("======================================");

        // Close the scanner to free resources
        sc.close();
    }
}