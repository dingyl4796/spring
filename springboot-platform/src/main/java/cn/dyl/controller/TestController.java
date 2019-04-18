package cn.dyl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.dyl.config.ApiInterceptor;


@RestController
@SpringBootConfiguration
public class TestController {
	@Autowired
	ApiInterceptor interceptor;
	
		@RequestMapping("/hello")
	   public String index() {
	       return "hello spring boot";
	   }
		
		@Value("${server.port}")
	    String port;
	    @RequestMapping("/home")
	    public String home(String name) {
	    	interceptor.setId(2);
	        return "hi "+name+",i am from port:" +port+",id:"+interceptor.getId();
	    }
	    
	    @RequestMapping("/index")
	    public ModelAndView main() {
	        ModelAndView mv = new ModelAndView("index");
	        return mv;
	    }
	    
}
