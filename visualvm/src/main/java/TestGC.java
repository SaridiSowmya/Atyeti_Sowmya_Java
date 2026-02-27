public class TestGC {
    public static void main(String[] args) throws Exception {
        while (true) {
            byte[] data = new byte[1024 * 1024]; // 1MB creating object of 1mb
            Thread.sleep(200);
        }
    }
}