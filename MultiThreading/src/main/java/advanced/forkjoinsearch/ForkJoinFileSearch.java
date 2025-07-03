package advanced.forkjoinsearch;

import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinFileSearch {
    public static void main(String[] args) {
        File rootDir = new File("C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sowmya_Java\\MultiThreading\\src\\main\\resources");
        String keyword = "TODO";

        FileSearchTask rootTask = new FileSearchTask(rootDir, keyword);

        ForkJoinPool pool = ForkJoinPool.commonPool();
        List<File> result = pool.invoke(rootTask);

        System.out.println("Matching files:");
        for (File file : result) {
            System.out.println(file.getAbsolutePath());
        }
    }
}


