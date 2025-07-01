package suppressedexception;

public class ResourceApp {
    public static void main(String[] args) {
        try (
                FileResource file = new FileResource();
                DataBaseConnection db = new DataBaseConnection()
        ) {
            file.readFile();
            db.executeQuery();

        } catch (Exception e) {
            System.err.println("Caught Exception: " + e.getMessage());

            for (Throwable suppressed : e.getSuppressed()) {
                System.err.println(" Suppressed: " + suppressed.getMessage());
            }
        }
    }
}
