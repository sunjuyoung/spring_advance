package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    //선 조립 후 실행 방법
    @Test
    public void strategyV2() throws Exception{
        Strategy strategy1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1");
            }
        };
        ContextV1 contextV1 = new ContextV1(strategy1);
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 2");
            }
        });

        //인터페이스 메서드가 1개만있으면 익명 내부클래스를 람다로 
        ContextV1 contextV3 = new ContextV1(()-> log.info("비즈니스 3"));
        contextV3.execute();

    }

    @Test
    public void strategyV1() throws Exception{
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    public void strategyMethodV0() throws Exception{
        //given
        logic();
        logic2();
    }

    private void logic() {
        long startTime = System.currentTimeMillis();
        log.info("비스니스 로직1 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTiem={}",resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();


        log.info("비스니스 로직2 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTiem={}",resultTime);
    }

    @Test
    public void templateMethodV1() throws Exception{
        //given
        AbstractTemplate template = new SubClassLogic1();
        template.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
        //when

        //then

    }


    /*익명 내부클래스 사용*/
    @Test
    public void templateMethodV2() throws Exception{
        AbstractTemplate template = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비스니스 로직1");
            }
        };
        log.info("클래스 이름 ={}",template.getClass());
        template.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비스니스 로직2");
            }
        };

        template2.execute();
        //given

        //when

        //then

    }
}
