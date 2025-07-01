package suppressedexception;

class DataBaseConnection implements AutoCloseable {
    public void executeQuery() throws Exception {
        System.out.println("Executing DB query...");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing DatabaseConnection...");
        throw new Exception(" Error closing DatabaseConnection");
    }
}
