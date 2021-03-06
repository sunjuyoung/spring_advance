package hello.proxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(AppV2Config.class)
//@SpringBootApplication(scanBasePackages = "hello.proxy.app") //주의, 하위 패키지만 스캔
@SpringBootApplication
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication();
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(ProxyApplication.class,args);

		//SpringApplication.run(ProxyApplication.class, args);
	}

}
