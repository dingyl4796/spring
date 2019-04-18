package cn.dyl.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import cn.dyl.service.MemberService;

@SpringBootConfiguration
@Component
public class ApiInterceptor extends WebMvcConfigurationSupport implements HandlerInterceptor {
	private Integer id;
	
	@Bean
    public ApiInterceptor interceptor(){
        return new ApiInterceptor();
    }
	
	@Override
    protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor());
        super.addInterceptors(registry);
    }
	
	@Autowired
	private MemberService memberService;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("进入拦截器");
		System.out.println(memberService);
		System.out.println(memberService.findMembers(1, 10, "", ""));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
