package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;


class ThreadLocalTraceTest {

    ThreadLocalTrace trace = new ThreadLocalTrace();

    @Test
    public void test(){
        TraceStatus userA = trace.begin("userA");
        TraceStatus userB = trace.begin("userB");

        trace.end(userB);
        trace.end(userA);
    }



}