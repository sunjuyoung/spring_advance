package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject{

    @Override
    public String operation() {
        log.info("실제 객체 호출");
        sleep(1000); //db나 외부에서 조회하는데 1초가 걸린다고 가정한다.
        return "data";
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        }catch (InterruptedException e){

        }

    }
}
