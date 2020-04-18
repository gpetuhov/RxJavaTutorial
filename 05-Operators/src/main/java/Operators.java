import io.reactivex.rxjava3.core.Observable;

public class Operators {

    public static void main(String[] args) {
        // Example
        Observable.just(23, 6, 67, 5, 89, 12, 78, 56, 95, 44)
                .filter(number -> number > 30)
                .sorted()
                .subscribe(System.out::println);

        // === Types of operators ===
        // === 1. Suppressing operators ===
        // filter()
        // take(n) - takes first n elements
        // skip(n) - skips first n elements
        // distinct() - suppresses duplicates
        // elementAt() - takes element at specified index
        // ...

        // === 2. Transforming operators ===
        // map()
        // cast()
        // delay()
        // delaySubscription()
        // scan()
        // sorted()
        // repeat()
        // ...

        // === 3. Reducing operators ===
        // Reduce a series of emissions into a single emission (Single)
        // Works only with finite observables
        // count()
        // reduce()
        // contains()
        // all()
        // any()
        // ...

        // === 4. Collection operators ===
        // Combine all emissions to some collection
        // (collection operators are reducing operators)
        // toList()
        // toSortedList()
        // toMap()
        // collect()
        // ...

        // === 5. Error recovery operators ===
        // onErrorReturnItem()
        // onErrorReturn()
        // onErrorResumeNext()
        // retry()
        // ...

        // === 6. Action operators ===
        // Used for debugging
        // doOnNext()
        // doOnError()
        // doOnSubscribe()
        // doOnComplete()
    }
}
