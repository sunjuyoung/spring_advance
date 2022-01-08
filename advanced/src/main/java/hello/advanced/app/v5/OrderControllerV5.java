package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderServiceV5;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderServiceV5, LogTrace logTrace) {
        this.orderServiceV5 = orderServiceV5;
        this.template = new TraceTemplate(logTrace);
    }

    @GetMapping("/v5/request")
    public String save(String itemId){
        String message = "OrderController.request()";
      return  template.execute(message, new TraceCallback<>() {
            @Override
            public String call() {
                orderServiceV5.orderItem(itemId);
                return "ok";
            }
        });
    }



}
