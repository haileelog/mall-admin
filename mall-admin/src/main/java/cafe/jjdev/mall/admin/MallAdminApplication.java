package cafe.jjdev.mall.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MallAdminApplication {

	public static void main(String[] args) {
		System.out.println("=======================tomcat 실행 전==========================");
		SpringApplication.run(MallAdminApplication.class, args);
		System.out.println("=======================Spring 구동 후==========================");
	}

}
