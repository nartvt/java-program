package com.elearning.program.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.elearning.program.repository.UserRepository;
import com.elearning.program.repository.impl.UserRepositoryImpl;
import com.elearning.program.service.UserService;
import com.elearning.program.service.impl.UserServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages =  {"com.elearning.program.controller","com.elearning.program.admin.controller"})
public class WebMvcConfig implements WebMvcConfigurer {
//  public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
//    viewResolverRegistry.jsp("/WEB-INF/views/", ".jsp");
//  }
  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
    tilesConfigurer.setCheckRefresh(true);
    return tilesConfigurer;
  }

  public void configureViewResolvers(ViewResolverRegistry registry) {
    TilesViewResolver tilesViewResolver = new TilesViewResolver();
    registry.viewResolver(tilesViewResolver);
  }

//  public void addResourcesHandlers(ResourceHandlerRegistry registry) {
//    registry.addResourceHandler("/statics/**").addResourceLocations("/resources/");
//  }

  @Bean
  public UserRepository userRepository() {
    return new UserRepositoryImpl();
  }

  @Bean
  public UserService userService() {
    return new UserServiceImpl();
  }
}
