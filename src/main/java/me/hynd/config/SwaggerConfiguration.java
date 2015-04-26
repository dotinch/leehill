package me.hynd.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.controllers.DefaultSwaggerController;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.paths.SwaggerPathProvider;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletContext;

/**
 * Created by H on 2015/4/25.
 */
@Configuration
@EnableWebMvc
@EnableSwagger
@ComponentScan("me.hynd.controller")
public class SwaggerConfiguration {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean //Don't forget the @Bean annotation
    public SwaggerSpringMvcPlugin customImplementation(){
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(".*")
                .pathProvider(new MvcAbsoluteSwaggerPathProvider());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "My Apps API Title",
                "My Apps API Description",
                "My Apps API terms of service",
                "My Apps API Contact Email",
                "My Apps API Licence Type",
                "My Apps API License URL"
        );
        return apiInfo;
    }

    class MvcAbsoluteSwaggerPathProvider extends SwaggerPathProvider {

        @Override
        protected String applicationPath() {
            return getAppRoot()
                    .build()
                    .toString();
        }

        @Override
        protected String getDocumentationPath() {
            return getAppRoot()
                    .path(DefaultSwaggerController.DOCUMENTATION_BASE_PATH)
                    .build()
                    .toString();
        }

        private UriComponentsBuilder getAppRoot() {
            return UriComponentsBuilder.fromHttpUrl("http://localhost:8080")
                    .path(servletContext.getContextPath());
        }
    }


}
