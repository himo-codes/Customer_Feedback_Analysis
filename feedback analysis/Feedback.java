import java.util.Scanner;

// ─── Feedback Class ───────────────────────────────────────
class Feedback {
    private int score;
    private String comment;

    public Feedback(int score, String comment) {
        this.score = score;
        this.comment = comment;
    }

    public int getScore()      { return score; }
    public String getComment() { return comment; }

    public void display() {
        System.out.println("  Score: " + score + " | Comment: " + comment);
    }
}

// ─── Analyzer Class ───────────────────────────────────────
class Analyzer {
    private Feedback[] feedbacks;

    public Analyzer(Feedback[] feedbacks) {
        this.feedbacks = feedbacks;
    }

    public double calculateAverage() {
        int total = 0;
        for (Feedback f : feedbacks) {
            total += f.getScore();
        }
        return (double) total / feedbacks.length;
    }

    public String categorizeSentiment(double avg) {
        int rounded = (int) Math.round(avg);
        switch (rounded) {
            case 5:  return "Excellent ⭐⭐⭐⭐⭐";
            case 4:  return "Good      ⭐⭐⭐⭐";
            case 3:  return "Average   ⭐⭐⭐";
            case 1:
            case 2:  return "Poor      ⭐";
            default: return "Unknown";
        }
    }

    public void printBreakdown() {
        int excellent = 0, good = 0, average = 0, poor = 0;
        for (Feedback f : feedbacks) {
            switch (f.getScore()) {
                case 5: excellent++; break;
                case 4: good++;      break;
                case 3: average++;   break;
                default: poor++;
            }
        }
        System.out.println("  Excellent (5) : " + excellent);
        System.out.println("  Good      (4) : " + good);
        System.out.println("  Average   (3) : " + average);
        System.out.println("  Poor    (1-2) : " + poor);
    }
}

// ─── Main Class ───────────────────────────────────────────
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   Customer Feedback Analysis System");
        System.out.println("========================================");

        System.out.print("How many feedback entries? ");
        int n = sc.nextInt();
        sc.nextLine();

        Feedback[] feedbacks = new Feedback[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Entry " + (i + 1) + " of " + n + " ---");

            int score = 0;
            while (score < 1 || score > 5) {
                System.out.print("  Rating (1-5): ");
                score = sc.nextInt();
                sc.nextLine();
                if (score < 1 || score > 5)
                    System.out.println("  Invalid! Please enter a value between 1 and 5.");
            }

            System.out.print("  Comment: ");
            String comment = sc.nextLine();

            feedbacks[i] = new Feedback(score, comment);
        }

        // ─── Analysis ─────────────────────────────────────
        Analyzer analyzer = new Analyzer(feedbacks);
        double avg         = analyzer.calculateAverage();
        String sentiment   = analyzer.categorizeSentiment(avg);

        // ─── Output ───────────────────────────────────────
        System.out.println("\n========================================");
        System.out.println("              RESULTS");
        System.out.println("========================================");

        System.out.println("\nAll Feedback Entries:");
        System.out.println("----------------------------------------");
        for (Feedback f : feedbacks) f.display();

        System.out.println("----------------------------------------");
        System.out.printf("Average Rating  : %.2f / 5.00%n", avg);
        System.out.println("Sentiment       : " + sentiment);

        System.out.println("\nScore Breakdown:");
        analyzer.printBreakdown();

        System.out.println("========================================");

        sc.close();
    }
}import java.util.Scanner;

// ─── Feedback Class ───────────────────────────────────────
class Feedback {
    private int score;
    private String comment;

    public Feedback(int score, String comment) {
        this.score = score;
        this.comment = comment;
    }

    public int getScore()      { return score; }
    public String getComment() { return comment; }

    public void display() {
        System.out.println("  Score: " + score + " | Comment: " + comment);
    }
}

// ─── Analyzer Class ───────────────────────────────────────
class Analyzer {
    private Feedback[] feedbacks;

    public Analyzer(Feedback[] feedbacks) {
        this.feedbacks = feedbacks;
    }

    public double calculateAverage() {
        int total = 0;
        for (Feedback f : feedbacks) {
            total += f.getScore();
        }
        return (double) total / feedbacks.length;
    }

    public String categorizeSentiment(double avg) {
        int rounded = (int) Math.round(avg);
        switch (rounded) {
            case 5:  return "Excellent ⭐⭐⭐⭐⭐";
            case 4:  return "Good      ⭐⭐⭐⭐";
            case 3:  return "Average   ⭐⭐⭐";
            case 1:
            case 2:  return "Poor      ⭐";
            default: return "Unknown";
        }
    }

    public void printBreakdown() {
        int excellent = 0, good = 0, average = 0, poor = 0;
        for (Feedback f : feedbacks) {
            switch (f.getScore()) {
                case 5: excellent++; break;
                case 4: good++;      break;
                case 3: average++;   break;
                default: poor++;
            }
        }
        System.out.println("  Excellent (5) : " + excellent);
        System.out.println("  Good      (4) : " + good);
        System.out.println("  Average   (3) : " + average);
        System.out.println("  Poor    (1-2) : " + poor);
    }
}

// ─── Main Class ───────────────────────────────────────────
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   Customer Feedback Analysis System");
        System.out.println("========================================");

        System.out.print("How many feedback entries? ");
        int n = sc.nextInt();
        sc.nextLine();

        Feedback[] feedbacks = new Feedback[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Entry " + (i + 1) + " of " + n + " ---");

            int score = 0;
            while (score < 1 || score > 5) {
                System.out.print("  Rating (1-5): ");
                score = sc.nextInt();
                sc.nextLine();
                if (score < 1 || score > 5)
                    System.out.println("  Invalid! Please enter a value between 1 and 5.");
            }

            System.out.print("  Comment: ");
            String comment = sc.nextLine();

            feedbacks[i] = new Feedback(score, comment);
        }

        // ─── Analysis ─────────────────────────────────────
        Analyzer analyzer = new Analyzer(feedbacks);
        double avg         = analyzer.calculateAverage();
        String sentiment   = analyzer.categorizeSentiment(avg);

        // ─── Output ───────────────────────────────────────
        System.out.println("\n========================================");
        System.out.println("              RESULTS");
        System.out.println("========================================");

        System.out.println("\nAll Feedback Entries:");
        System.out.println("----------------------------------------");
        for (Feedback f : feedbacks) f.display();

        System.out.println("----------------------------------------");
        System.out.printf("Average Rating  : %.2f / 5.00%n", avg);
        System.out.println("Sentiment       : " + sentiment);

        System.out.println("\nScore Breakdown:");
        analyzer.printBreakdown();

        System.out.println("========================================");

        sc.close();
    }
}