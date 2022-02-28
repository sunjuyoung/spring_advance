package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldLogTrace implements LogTrace{

    private static final String START_PREFIX = "--->";
    private static final String COMPLETE_PREFIX = "<---";
    private static final String EX_PREFIX = "<X--";


    private TraceId traceHolder;

    @Override
    public TraceStatus begin(String message) {
       TraceId traceId = new TraceId();
        Long startTime = System.currentTimeMillis();
        
        log.info("[{}] {}{}",traceId.getId(),addSpace(START_PREFIX,traceId.getLevel()),message);



        return null;
    }

    private static String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<level; i++){
            sb.append((i == level -1)? "|"+prefix : "|    ");
        }
        return sb.toString();
    }

    @Override
    public void end(TraceStatus status) {
        complete(status,null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status,e);
    }

    private void complete(TraceStatus status, Exception e) {
        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime -  status.getStartTimeMs();
    }
}
