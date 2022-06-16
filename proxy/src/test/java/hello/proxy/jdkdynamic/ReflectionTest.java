package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    public void reflection0(){
        Hello target = new Hello();
        //공통 로직1 시작
        log.info("start");
        String result1 = target.callA(); //호출하는 메서드가 다름
        log.info("result={}", result1);
        //공통 로직1 종료
        //공통 로직2 시작
        log.info("start");
        String result2 = target.callB(); //호출하는 메서드가 다름
        log.info("result={}", result2);
        //공통 로직2 종
    }

    @Test
    public void reflection1() throws Exception{
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        //해당 클레스에 callA메서드 메타정보를 획득한다,. 클래스안에 메서드만 가능
        Method methodCallA = classHello.getMethod("callA");
        //target에 있는 methodCallA를 호출한다
        Object result1 = methodCallA.invoke(target);
        log.info("result = {}", result1);


        Method methodCallB = classHello.getMethod("callB");
        //target에 있는 methodCallA를 호출한다
        Object result2 = methodCallB.invoke(target);
        log.info("result = {}", result2);
    }

    //리플렉션 기술은 런타임에 동작하기 때문에, 컴파일 시점에 오류를 잡을 수 없다.
    @Test
    public void reflection2() throws Exception{
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA,target);


        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB,target);

    }
    //메서드 정보가 동적으로 제공
    private void dynamicCall(Method method, Object target) throws Exception{
        log.info("start");
       // String result1 = target.callA(); //호출하는 메서드가 다름
        Object result = method.invoke(target);
        log.info("result={}", result);
    }


    @Slf4j
    static class Hello{
        public String callA(){
            log.info("callA");
            return "A";
        }
        public String callB(){
            log.info("callB");
            return "B";
        }
    }
}
