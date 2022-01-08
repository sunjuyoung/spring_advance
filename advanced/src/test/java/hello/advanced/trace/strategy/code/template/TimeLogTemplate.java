package hello.advanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback){
        long startTime = System.currentTimeMillis();
        log.info("비스니스 로직1 실행");

        callback.call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTiem={}",resultTime);
    }
}
