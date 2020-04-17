import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObservableVariants {

    public static void main(String[] args) {

        // === Single ===

        // This is ordinary observable
        Observable<String> source = Observable.just("Apple", "Grape", "Strawberry");

        // Convert it into Single by taking the first element
        source
                .first("Mango")
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("Subscribe");
                    }

                    @Override
                    public void onSuccess(@NonNull String s) {
                        System.out.println("Success, s = " + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("Error");
                    }
                });

        // Another way of creating Single
        Single.just("Plum")
                .subscribe(System.out::println);
    }
}