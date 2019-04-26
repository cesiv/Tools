package com.jumper.pdf.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


@Component
public class ExceptionHandler implements HandlerExceptionResolver
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);
    
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
    {
        LOGGER.error(handler.toString(), exception);
        return null;
    }
}
