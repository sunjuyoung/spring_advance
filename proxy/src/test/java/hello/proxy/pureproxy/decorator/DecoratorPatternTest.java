package hello.proxy.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    public void noDeco(){
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }
    @Test
    public void Deco1(){
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    public void Deco2(){
        Component realComponent = new RealComponent();

        MessageDecorator messageDecorator = new MessageDecorator(realComponent);

        Component timeDeco = new TimeDecorator(messageDecorator);

        DecoratorPatternClient client = new DecoratorPatternClient(timeDeco);
        client.execute();
    }

}
