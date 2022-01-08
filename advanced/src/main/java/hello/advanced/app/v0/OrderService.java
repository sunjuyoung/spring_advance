package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private  final OrderRepositoryVO orderRepositoryVO;

    public void orderItem(String itemId){
        orderRepositoryVO.save(itemId);
    }
}
