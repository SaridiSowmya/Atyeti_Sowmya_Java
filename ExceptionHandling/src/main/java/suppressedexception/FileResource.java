package suppressedexception;

class FileResource implements AutoCloseable {
    public void readFile() throws Exception {
        System.out.println("Reading file...");
        throw new Exception(" Exception during file read");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing FileResource...");
        throw new Exception(" Error closing FileResource");
    }
}




