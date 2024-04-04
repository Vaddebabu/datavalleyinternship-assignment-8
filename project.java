import java.util.*;

class Project {
    private String studentName;
    private int completionTime;
    private int deadline;

    public Project(String studentName, int completionTime, int deadline) {
        this.studentName = studentName;
        this.completionTime = completionTime;
        this.deadline = deadline;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public int getDeadline() {
        return deadline;
    }

    public String getStatus() {
        if (completionTime <= deadline) {
            return "On time";
        } else if (completionTime > deadline) {
            return "Late";
        } else {
            return "Early";
        }
    }
}

public class ProjectTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Project> projects = new ArrayList<>();

        // Accepting project details
        System.out.print("Enter the number of projects: ");
        int numProjects = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numProjects; i++) {
            System.out.println("Enter details for project " + (i + 1) + ":");
            System.out.print("Student name: ");
            String studentName = scanner.nextLine();
            System.out.print("Completion time (in days): ");
            int completionTime = scanner.nextInt();
            System.out.print("Deadline (in days): ");
            int deadline = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Project project = new Project(studentName, completionTime, deadline);
            projects.add(project);
        }

        // Calculating statistics
        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;
        Map<String, Integer> studentCompletionTimes = new HashMap<>();
        for (Project project : projects) {
            if (project.getStatus().equals("On time")) {
                onTimeCount++;
            } else if (project.getStatus().equals("Late")) {
                lateCount++;
            } else {
                earlyCount++;
            }
            int totalTime = studentCompletionTimes.getOrDefault(project.getStudentName(), 0) + project.getCompletionTime();
            studentCompletionTimes.put(project.getStudentName(), totalTime);
        }

        // Displaying statistics
        System.out.println("\nProject completion statistics:");
        System.out.println("On time: " + onTimeCount);
        System.out.println("Late: " + lateCount);
        System.out.println("Early: " + earlyCount);
        System.out.println("\nAverage completion time per student:");
        for (Map.Entry<String, Integer> entry : studentCompletionTimes.entrySet()) {
            double avgCompletionTime = (double) entry.getValue() / numProjects;
            System.out.println(entry.getKey() + ": " + avgCompletionTime + " days");
        }
    }
}
