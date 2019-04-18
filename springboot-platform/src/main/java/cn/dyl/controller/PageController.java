package cn.dyl.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class PageController {
	
	@RequestMapping("test")
    public String home(){
        return "index";
    }
	
	
	@Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

	
	private final static PageController INSTANCE=new PageController();
	
	private PageController() {
		
	}
	
	public static PageController getInstance() {
		return INSTANCE;
	}
}
