package hello.proxy.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component{

    @Override
    public String operation() {
      log.info("realCompoenet 실행");
        return "data";
    }
}
