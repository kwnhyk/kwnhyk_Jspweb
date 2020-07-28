package Lecture.Evaluation.util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


	// Spring IoC 컨테이너가 탐색할 패키지 설정
	// => 지정한 패키지 및 그 하위 패키지를 모두 뒤져서
	// @Component 애노테이션이 붙은 클래스를 찾아 객체를 생성한다.
	//
	@ComponentScan(value = "Lecture.Evaluation")
	
		@EnableWebMvc
		public class AppConfig implements WebMvcConfigurer {

		  static Logger logger = LogManager.getLogger(AppConfig.class);


		  public AppConfig() {
		    logger.debug("AppConfig 객체 생성!");
		  }
	
	 @Bean
	  public ViewResolver viewResolver() {
	    InternalResourceViewResolver vr = new InternalResourceViewResolver(//
	        "/WEB-INF/jsp/", // prefix
	        ".jsp" // suffix
	    );
	    return vr;
	  }
	 }

	 
	  // Spring IoC 컨테이너에 수동으로 객체를 등록하고 싶다면,
	  // 그 객체를 만들어 주는 팩토리 메서드를 정의해야 한다.
	  // => 단 메서드 선언부에 @Bean 애노테이션을 붙여야 한다.
	  // => 그래야만 Spring IoC 컨테이너는
	  // 이 메서드를 호출하고 그 리턴 값을 보관한다.




