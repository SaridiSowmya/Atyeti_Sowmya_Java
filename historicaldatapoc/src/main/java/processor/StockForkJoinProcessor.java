package processor;

import model.StockRecord;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.RecursiveAction;

public class StockForkJoinProcessor extends RecursiveAction {

    private static final int THRESHOLD = 200;
    private final List<StockRecord> records;

    public StockForkJoinProcessor(List<StockRecord> records) {
        this.records = records;
    }

    @Override
    protected void compute() {

        if (records.size() <= THRESHOLD) {
            processSequential();
            return;
        }

        int mid = records.size() / 2;
        invokeAll(
                new StockForkJoinProcessor(records.subList(0, mid)),
                new StockForkJoinProcessor(records.subList(mid, records.size()))
        );
    }

    private void processSequential() {

        Map<String, LocalDate> latestDateMap = new HashMap<>();

        for (StockRecord r : records) {
            latestDateMap.merge(
                    r.getSymbol(),
                    r.getDate(),
                    (existingDate, newDate) -> existingDate.isAfter(newDate) ? existingDate : newDate
            );
        }

        for (StockRecord r : records) {
            LocalDate latest = latestDateMap.get(r.getSymbol());
            r.setIsUpdated(r.getDate().equals(latest) ? 401 : 400);
        }
    }
}
