import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HotStreamone {

    public static void main(String args[]) {
        List<Integer> elements = new ArrayList<>();

        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
            while (true)
                fluxSink.next(System.currentTimeMillis());
        }).sample(Duration.ofSeconds(2)).publish();

        publish.subscribe(System.out::println);
        publish.connect();

    }

}
