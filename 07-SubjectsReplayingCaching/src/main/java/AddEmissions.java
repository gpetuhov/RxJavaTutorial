import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class AddEmissions {

    public static void main(String[] args) throws InterruptedException {

        Subject<String> subject = PublishSubject.create();

        subject.subscribe(System.out::println);

        // We can manually emit items to the Subject
        subject.onNext("Hello");
        subject.onNext("world");
        
        // After we have called onComplete, no further items will be emitted
        subject.onComplete();
        subject.onNext("Blablabla");

        // Subjects are not thread-safe by default.
        // To make them thread-safe we should call toSerialized
        Subject<String> subject2 = PublishSubject.create();
        Subject<String> serialized = subject2.toSerialized();

        serialized.subscribe(System.out::println);
        serialized.onNext("Hello 222");
    }
}
