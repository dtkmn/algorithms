package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ParallelizeForLoop {

    public void processSerially() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(10);
        }
    }

    public void processParallelWithExecutorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, executorService);
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();
    }

    public void processParallelWithStream() {
        IntStream.range(0, 100)
            .parallel()
            .forEach(i -> {
                try {
                    Thread.sleep(10);
                    System.out.println(this.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
    }

    public void processParallelWithStreamSupport() {
        Iterable<Integer> iterable = () -> IntStream.range(0, 100).iterator();
        Stream<Integer> stream = StreamSupport.stream(iterable.spliterator(), true);
        stream.forEach(i -> {
            try {
                Thread.sleep(10);
                System.out.println(this.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new ParallelizeForLoop().processParallelWithStream();
        new ParallelizeForLoop().processParallelWithStreamSupport();
    }

}
