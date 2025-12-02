package task;
import model.Stock;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CsvFolderTask extends RecursiveTask<List<Stock>> {

    private final File folder;

    public CsvFolderTask(File folder) {
        this.folder = folder;
    }

    @Override
    protected List<Stock> compute() {

        List<CsvFileTask> tasks = new ArrayList<>();

        for (File file : folder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".csv")) {
                CsvFileTask task = new CsvFileTask(file);
                task.fork();
                tasks.add(task);
            }
        }
        List<Stock> finalList = new ArrayList<>();
        for (CsvFileTask task : tasks) {
            finalList.addAll(task.join());
        }
        return finalList;
    }
}
