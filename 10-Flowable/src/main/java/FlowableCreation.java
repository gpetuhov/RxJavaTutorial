import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlowableCreation {

    public static void main(String[] args) throws InterruptedException {
        // To create a Flowable we must provide backpressure strategy
        Flowable.create(emitter -> {
            for (int i = 0; i < 5000; i++) {
                if (emitter.isCancelled()) return;
                emitter.onNext(i);
            }
        }, BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
