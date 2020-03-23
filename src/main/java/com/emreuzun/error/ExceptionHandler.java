package com.emreuzun.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
class ExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        logger.error(exception.getMessage(), exception);
        return new ModelAndView("error/general");
    }
}
