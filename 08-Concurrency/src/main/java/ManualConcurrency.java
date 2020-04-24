import io.reactivex.rxjava3.core.Observable;

// This is how to make an observer run on a background thread
public class ManualConcurrency {

    public static void main(String[] args) {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("world");
        });

        // This will run on the main thread
        source.subscribe(item -> System.out.println("Observer 1: " + item + ", Thread: " + Thread.currentThread().getName()));
        source.subscribe(item -> System.out.println("Observer 2: " + item + ", Thread: " + Thread.currentThread().getName()));

        System.out.println();

        Observable<String> source2 = Observable.create(emitter -> {
            new Thread(() -> {
                emitter.onNext("Hello");
                emitter.onNext("world");
            }).start();
        });

        // This will run on background threads
        source2.subscribe(item -> System.out.println("Observer 1: " + item + ", Thread: " + Thread.currentThread().getName()));
        source2.subscribe(item -> System.out.println("Observer 2: " + item + ", Thread: " + Thread.currentThread().getName()));
    }
}
