import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObservableVariants {

    public static void main(String[] args) {

        // === Single ===
        // Emit only 1 item

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

        // === Maybe ===
        // Emit 0 or 1 item

        source.firstElement()
                .subscribe(new MaybeObserver<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("Maybe subscibe");
                    }

                    // This will be called, if the element is emitted
                    @Override
                    public void onSuccess(@NonNull String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("Maybe error");
                    }

                    // This will be called, if there are not elements,
                    // for example if we subscribe to Observable.empty().firstElement();
                    @Override
                    public void onComplete() {
                        System.out.println("Maybe complete");
                    }
                });
    }
}