import java.util.Scanner;

public class project_1 {

    
    static class Feedback {
        private int rate;
        private String comment;

        public Feedback(int rate, String comment) {
            this.rate = rate;
            this.comment = comment;
        }

        public int getrate() {
            return rate;
        }

        public String getComment() {
            return comment;
        }
    }

    
    static class Analyzer {

        public double calculateAverage(Feedback[] feedbacks) {
            int sum = 0;

            for (Feedback f : feedbacks) {
                sum += f.getrate();
            }

            return (double) sum / feedbacks.length;
        }

        public String getSentiment(double avg) {
            int rounded = (int) Math.round(avg);

            switch (rounded) {
                case 5:
                    return "Excellent";
                case 4:
                    return "Good";
                case 3:
                    return "Average";
                case 1:
                case 2:
                    return "Poor";
                default:
                    return "Invalid";
            }
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of feedbacks: ");
        int n = sc.nextInt();
        sc.nextLine();

        Feedback[] feedbacks = new Feedback[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nFeedback " + (i + 1));

            System.out.print("Enter rate (1-5): ");
            int rate = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter comment: ");
            String comment = sc.nextLine();

            feedbacks[i] = new Feedback(rate, comment);
        }

        Analyzer analyzer = new Analyzer();

        double avg = analyzer.calculateAverage(feedbacks);
        String sentiment = analyzer.getSentiment(avg);

        System.out.println("\nAverage Rating: " + avg);
        System.out.println("Customer Sentiment: " + sentiment);

        sc.close();
    }
}