package my.ky.test.web.handler;

import my.ky.test.commons.exception.BusiException;
import my.ky.test.commons.model.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <ul>
 * <li>全局异常处理</li>
 * <li>User:ky Date:2018/1/24 Time:9:50</li>
 * </ul>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = BusiException.class)
    @ResponseBody
    public Response<Object> jsonErrorHandler(HttpServletRequest req, BusiException e) {
        Response<Object> response = new Response<>(e.getCode(), e.getMessage());
        response.setUrl(req.getRequestURL().toString());
        return response;
    }
}
