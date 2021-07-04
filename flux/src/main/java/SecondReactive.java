import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class SecondReactive {

    public static void main(String args[]) {
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i*2)
                .subscribe(new Subscriber<Integer>() {
                    Subscription s;

                    @Override
                    public void onSubscribe(Subscription s) {
                        this.s = s;
                        System.out.println("on subs");
                        s.request(1);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("on next");
                        elements.add(integer);
                        s.request(1);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("on error");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("on complete");
                    }
                });

        System.out.println(elements);

    }

}
