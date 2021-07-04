import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class CombineStreams {

    public static void main(String args[]) {
        List<Object> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i*2)
                .zipWith(Flux.range(0, Integer.MAX_VALUE),
                        (one, second) -> String.format("First Flux: %d, Second Flux: %d", one, second))
                .subscribe(elements::add);

    }


}
