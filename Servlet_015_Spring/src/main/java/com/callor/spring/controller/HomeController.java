package com.callor.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.spring.model.MyVO;
import com.callor.spring.service.HomeService;

@Controller
public class HomeController {
	
	/*
	 * Controller에서 HomeService 인터페이스를 상속받은
	 *  MyServiceImplV1 클래스를 사용하여
	 *  findById() method를 호출한 후 VO 데이터를 받고 싶다
	 *  
	 * 전통적인 Java 클래스간의 연결은 
	 *  인터페이스로 객체를 선언하고,
	 *  클래스로 객체를 생성(초기화)하여 가지고 있다가
	 *  필요한 method를 호출할수 있도록 만들어진다
	 *  
	 * 하지만 SpringFramework 환경에서는
	 *  객체를 미리 Spring이 만들어 보관하고 있다가
	 *  필요한 곳이 있으면 그때그때 배분하여 사용할 수 있도록
	 *  만들어 준다
	 *  
	 * 프로젝트가 커져서 많은 객체가 필요할때
	 *  전통적 프로그래밍은 모든 객체를 선언, 생성하여
	 *  가지고(메모리에 보관)있어야 하기 때문에 
	 *  어느정도 프로젝트가 커지면 여러가지 관리해야 할 일들이 많아진다
	 *  
	 * SpringFramework 환경에서는 그러한 것들을 극복하기 위하여
	 * 	미리 객체를 만들어서 Spring 컨테이너 라는 곳에
	 *  보관해 두고, 
	 *  
	 *  필요한 곳에 적절히 주입을 해준다
	 *  
	 *  이러한 개념을 DI(Dependency Inject)라고 하며
	 *   전통 방식과 반대되는 개념이어서 제어의 역전(Ioc)라고 부른다
	 */
	
	private final HomeService hService;
	
	@Autowired  // -> 정보가 필요하다고 요청
	public HomeController(HomeService hService) {
		this.hService = hService; 
	}
	
	@ResponseBody
	@RequestMapping(value = "/")
	public String index() {
		// responseBody가 있으면 아래 문자열을 그대로 web server에 보여라하는 것임
		return "Hello Korea";
	}
	
	@RequestMapping(value = "/see", method=RequestMethod.GET)
	public String home(Model model) {
		
		
		model.addAttribute("MY",hService.findById());
		
		// responseBody가 붙어있지 않기때문에 jsp파일을 열어서 web server에 보여라하는 것임
		return "home";
	}
	
	@RequestMapping(value = "/see", method=RequestMethod.POST)
	public String home(MyVO vo, Model model) {
		
		System.out.println(vo.toString());
		
		model.addAttribute("MY",vo);
		
		return "home";
	}
}
