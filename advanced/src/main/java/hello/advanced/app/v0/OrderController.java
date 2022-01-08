package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/v0/request")
    public String save(String itemId){
        orderService.orderItem(itemId);
        return "ok";
    }



}
