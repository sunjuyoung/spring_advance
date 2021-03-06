package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.*;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {



    @Test
    public void strategyV3() throws Exception{
       //given
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());

        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2");
            }
        });

        contextV2.execute(()-> log.info("비즈니스 로직 3 람다 실행"));
    }

    @Test
    public void strategyV2() throws Exception{
       //StrategyLogic에 메서드가 한개만 있어야한다
       ContextV1 contextV1 = new ContextV1(()->log.info("비즈니스 로직1"));
       contextV1.execute();


    }

    @Test
    public void strategyV1() throws Exception{
        ContextV2 contextV2 = new ContextV2();

        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }


}
