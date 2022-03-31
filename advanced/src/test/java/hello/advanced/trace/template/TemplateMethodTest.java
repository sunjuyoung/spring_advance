package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    public void templateMethodV0() throws Exception{
       //given
       logic();
       logic2();
       //when

       //then

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
