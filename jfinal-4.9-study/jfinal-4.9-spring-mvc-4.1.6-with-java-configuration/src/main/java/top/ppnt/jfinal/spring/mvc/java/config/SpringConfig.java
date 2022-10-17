package top.ppnt.jfinal.spring.mvc.java.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration // 表明该类是一个Spring配置类
@ComponentScan({ "top.ppnt.jfinal.spring.mvc.java.config" }) // 对应第四步，扫描包
//@EnableWebMvc // 实现SpringMVC功能
public class SpringConfig extends WebMvcConfigurerAdapter {
}
