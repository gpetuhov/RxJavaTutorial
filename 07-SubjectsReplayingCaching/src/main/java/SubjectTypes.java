import io.reactivex.rxjava3.subjects.*;

public class SubjectTypes {

    public static void main(String[] args) {

        // === PublishSubject ===
        // Starts to emit the source observables from the moment observer subscribes to it

        Subject<String> subject = PublishSubject.create();

        // These items will not be emitted, because no observer subscribed to the subject
        subject.onNext("a");
        subject.onNext("b");

        subject.subscribe(item -> System.out.println("Observer 1: " + item));

        // These items will be received by Observer 1 only
        subject.onNext("c");
        subject.onNext("d");
        subject.onNext("e");

        subject.subscribe(item -> System.out.println("Observer 2: " + item));

        // These items will be received both by Observer 1 and 2
        subject.onNext("f");
        subject.onNext("g");

        System.out.println();

        // === ReplaySubject ===
        // Emits all the items of the source observable, regardless of when the subscriber subscribes

        Subject<String> replaySubject = ReplaySubject.create();

        // Here both observers will receive all the items emitted

        replaySubject.onNext("a");
        replaySubject.onNext("b");

        replaySubject.subscribe(item -> System.out.println("Observer 1: " + item));

        replaySubject.onNext("c");
        replaySubject.onNext("d");
        replaySubject.onNext("e");

        replaySubject.subscribe(item -> System.out.println("Observer 2: " + item));

        replaySubject.onNext("f");
        replaySubject.onNext("g");

        System.out.println();

        // === BehaviorSubject ===
        // Emits the most recent item with the subsequent items of the source observable from the point of subscription

        Subject<String> behaviorSubject = BehaviorSubject.create();

        // Here Observer 1 will receive items starting from "b"
        // and Observer 2 - starting from "e"

        behaviorSubject.onNext("a");
        behaviorSubject.onNext("b");

        behaviorSubject.subscribe(item -> System.out.println("Observer 1: " + item));

        behaviorSubject.onNext("c");
        behaviorSubject.onNext("d");
        behaviorSubject.onNext("e");

        behaviorSubject.subscribe(item -> System.out.println("Observer 2: " + item));

        behaviorSubject.onNext("f");
        behaviorSubject.onNext("g");

        System.out.println();

        // === AsyncSubject ===
        // Emits only the last value of the source observable.
        // Emits only after onComplete has been called.

        Subject<String> asyncSubject = AsyncSubject.create();

        // Here both observers will receive "g"

        asyncSubject.onNext("a");
        asyncSubject.onNext("b");

        asyncSubject.subscribe(item -> System.out.println("Observer 1: " + item));

        asyncSubject.onNext("c");
        asyncSubject.onNext("d");
        asyncSubject.onNext("e");

        asyncSubject.subscribe(item -> System.out.println("Observer 2: " + item));

        asyncSubject.onNext("f");
        asyncSubject.onNext("g");

        // Without this AsyncSubject will not emit anything
        asyncSubject.onComplete();

        System.out.println();
    }
}
