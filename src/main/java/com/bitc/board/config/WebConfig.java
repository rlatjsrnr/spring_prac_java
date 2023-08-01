package com.bitc.board.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
// webapplicationInitializer의 구현체이며
// was는 web.xml 보조하기위한 객체로 생성된 클래스에서 WebapplicationInitializer를
// 검색한다.
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletContextConfig.class};
	}
	// 동일한 인덱스번호로 맵핑시킴
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		// 인코딩이 있던 없던 상관없이 무조건 인코딩을 지정한다. 디폴트는 false
		filter.setForceEncoding(true);
		return new Filter[] {filter};
	}
	
}
