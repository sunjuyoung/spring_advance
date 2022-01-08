package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;


class ThreadLocalTraceTest {

    ThreadLocalTrace trace = new ThreadLocalTrace();

    @Test
    void begin_end_level2(){
        TraceStatus status = trace.begin("hello1");
        TraceStatus status1 = trace.begin("hello2");
        trace.end(status1);
        trace.end(status);
    }

}