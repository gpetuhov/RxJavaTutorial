import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

// Cold Observables

public class ColdObservables {

    public static void main(String[] args) {
        List<String> fruit = new ArrayList<>();
        fruit.add("Peach");
        fruit.add("Pineapple");

        Observable<String> source = Observable.fromIterable(fruit);

        source.subscribe(System.out::println);

        // If we update the data...
        fruit.add("Grapes");

        // ...the observable will emit the updated data to all the new subscriptions
        // and for every new subscription it will start emitting from the very beginning.
        source.subscribe(System.out::println);
    }
}
