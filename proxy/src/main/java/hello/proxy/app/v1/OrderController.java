package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.*;

@RequestMapping
@ResponseBody
public class OrderController {

    private final OrderServiceV1 orderServiceV1;

    public OrderController(OrderServiceV1 orderServiceV1) {
        this.orderServiceV1 = orderServiceV1;
    }

    @GetMapping("/v1/request")
    public String request(@RequestParam("itemId")String itemId){
        orderServiceV1.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v1/no-log")
    public String noLog(){
        return "ok";
    }
}
