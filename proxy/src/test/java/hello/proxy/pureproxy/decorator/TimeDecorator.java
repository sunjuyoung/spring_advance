package hello.proxy.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component{

    private Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("timedoco 실행");
        long statTime = System.currentTimeMillis();
        String result = component.operation();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime  - statTime;
        log.info("timedeco 종료 : {}" ,resultTime);
        return result;
    }
}
