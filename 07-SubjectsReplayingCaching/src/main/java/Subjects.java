import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

// Subjects can act as Observables and Observers at the same time

public class Subjects {

    public static void main(String[] args) throws InterruptedException {

        Observable<Integer> source1 = Observable.just(5, 10, 15, 20);
        Observable<Integer> source2 = Observable.just(50, 100, 150, 200);

        Subject<Integer> subject = PublishSubject.create();

        subject.subscribe(item -> System.out.println(item));

        source1.subscribe(subject);
        source2.subscribe(subject);

        // We will get emissions only from the source1.
        // That is because Subjects are hot Observables, they start emitting only once.
        // When Subject subscribed to the source1, it started executing observer passed to it.
        // When Subject received onComplete from the source1, it stopped emitting.
        // Subscribing to source2 does not restart emissions, because the Subject is already complete.

        // To get emissions from both sources, we have to make them async
        // (in this case they will complete almost simultaneously).
        Observable<Integer> source3 = Observable.just(5, 10, 15, 20)
                .subscribeOn(Schedulers.computation());
        Observable<Integer> source4 = Observable.just(50, 100, 150, 200)
                .subscribeOn(Schedulers.computation());

        Subject<Integer> subject2 = PublishSubject.create();

        // Subjects may have several observers
        subject2.subscribe(item -> System.out.println("Observer 1: " + item));
        subject2.subscribe(item -> System.out.println("Observer 2: " + item));

        source3.subscribe(subject2);
        source4.subscribe(subject2);

        Thread.sleep(1000);
    }
}
