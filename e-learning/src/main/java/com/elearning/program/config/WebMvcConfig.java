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

@Configuration
@EnableWebMvc
@ComponentScan("com.elearning.program")
public class WebMvcConfig implements WebMvcConfigurer {
//  public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
//    viewResolverRegistry.jsp("/WEB-INF/views/", ".jsp");
//  }
  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
    tilesConfigurer.setCheckRefresh(true);
    return tilesConfigurer;
  }
  public void configureViewResolvers(ViewResolverRegistry registry) {
    TilesViewResolver tilesViewResolver =new TilesViewResolver();
    registry.viewResolver(tilesViewResolver);
  }
  
  public void addResourcesHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/statics/**").addResourceLocations("/resources/");
  }
  
}
