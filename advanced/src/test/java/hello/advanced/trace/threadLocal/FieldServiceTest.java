package hello.advanced.trace.threadLocal;

import hello.advanced.trace.threadLocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    public void field(){
        log.info("main start");
        Runnable userA = () ->{
            fieldService.logic("userA");
        };
        Runnable userB = () ->{
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("threadA");

        Thread threadB = new Thread(userB);
        threadA.setName("threadB");

        threadA.start();
        sleep(2000);
        threadB.start();
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
