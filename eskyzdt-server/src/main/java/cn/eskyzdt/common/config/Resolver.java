
package cn.eskyzdt.common.config;


import cn.eskyzdt.modules.designmodule.simplefactory.Product;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class Resolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType().isAssignableFrom(UserDetails.class) && parameter.hasParameterAnnotation(Produc.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
		Product product = (Product) webRequest.getAttribute("product", RequestAttributes.SCOPE_REQUEST);
		return product;
	}
}
