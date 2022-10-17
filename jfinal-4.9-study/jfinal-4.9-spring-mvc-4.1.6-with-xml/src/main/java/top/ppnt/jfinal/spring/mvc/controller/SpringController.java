package top.ppnt.jfinal.spring.mvc.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Ping E Lee
 *
 */
@RestController
@RequestMapping("spring")
@Slf4j
public class SpringController {

  @Autowired
  private ApplicationContext applicationContext;

  @RequestMapping("beans")
  public String[] beans() {
    String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
    log.info("beanDefinitionNames:{}", Arrays.toString(beanDefinitionNames));
    return beanDefinitionNames;
  }
}
