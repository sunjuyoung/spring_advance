package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryVO {

    public void save(String itemId){
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외 발생");
        }
        sleep(1000);
    }

    private void sleep(int mil){
        try{
            Thread.sleep(mil);
        }catch (Exception e){

        }

    }
}
