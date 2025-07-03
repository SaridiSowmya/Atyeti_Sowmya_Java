package advanced.forkjoinsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FileSearchTask extends RecursiveTask<List<File>> {
    private final File directory;
    private final String keyword;

    public FileSearchTask(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    protected List<File> compute() {
        List<File> matchedFiles = new ArrayList<>();
        List<FileSearchTask> subTasks = new ArrayList<>();

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    FileSearchTask task = new FileSearchTask(file, keyword);
                    task.fork();
                    subTasks.add(task);
                } else if (file.isFile()) {
                    if (containsKeyword(file, keyword)) {
                        matchedFiles.add(file);
                    }
                }
            }
        }


        for (FileSearchTask task : subTasks) {
            matchedFiles.addAll(task.join());
        }

        return matchedFiles;
    }

    private boolean containsKeyword(File file, String keyword) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getAbsolutePath());
        }
        return false;
    }
}


