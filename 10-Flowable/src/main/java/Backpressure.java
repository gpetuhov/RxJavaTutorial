import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Backpressure {

    public static void main(String[] args) throws InterruptedException {
        // Flowable produces 128 items.
        // Then it waits for the consumer to consume 96 items.
        // Then it produces another 96 items and so on.
        Flowable.range(1, 100000)
                .doOnNext(item -> {
                    System.out.println("Produced item: " + item + ", Thread: " + Thread.currentThread().getName());
                })
                .observeOn(Schedulers.io())
                .subscribe(item2 -> {
                    Thread.sleep(100);
                    System.out.println("Consumed item: " + item2 + ", Thread: " + Thread.currentThread().getName());
                });

        Thread.sleep(60000);
    }
}
