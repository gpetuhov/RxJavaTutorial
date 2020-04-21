import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

import java.util.concurrent.TimeUnit;

public class Subjects2{

    public static void main(String[] args) throws InterruptedException {

        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(item -> "Source 1: " + item * 1000)
                .take(3);
        Observable<String> source2 = Observable.interval(500, TimeUnit.MILLISECONDS)
                .map(item -> "Source 2: " + item);

        Subject<String> subject = PublishSubject.create();

        subject.subscribe(System.out::println);

        source1.subscribe(subject);
        source2.subscribe(subject);

        // Here source1 will complete after 3 items.
        // This will call onComplete of our subject, and it will stop emissions.

        Thread.sleep(10000);
    }
}
