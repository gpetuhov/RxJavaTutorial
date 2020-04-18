import io.reactivex.rxjava3.core.Observable;

import java.util.Comparator;

public class CollectionOperators {

    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> source = Observable.just(23, 5, 67, 5, 89, 12, 78, 56, 95, 44);

        source
                .toList()
                .subscribe(System.out::println);

        System.out.println();

        source
                .toSortedList(Comparator.reverseOrder())
                .subscribe(System.out::println);

        System.out.println();

        source
                // Convert into map with key generated according to provided function
                .toMap(item -> "item_" + item)
                .subscribe(System.out::println);

        System.out.println();
   }
}