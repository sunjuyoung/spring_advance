package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    public void strategyV2() throws Exception{
       //StrategyLogic에 메서드가 한개만 있어야한다
       ContextV1 contextV1 = new ContextV1(()->log.info("비즈니스 로직1"));
       contextV1.execute();
       //when

       //then

    }

    @Test
    public void strategyV1() throws Exception{
       //given
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();
        //when

        StrategyLogic1 strategyLogic2 = new StrategyLogic1();
        ContextV1 contextV2 = new ContextV1(strategyLogic1);
        contextV2.execute();
       //then
       
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
