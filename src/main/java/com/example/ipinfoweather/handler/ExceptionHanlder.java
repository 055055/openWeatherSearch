package com.example.ipinfoweather.handler;

import com.example.ipinfoweather.dto.ResultError;
import com.example.ipinfoweather.error.ServiceException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ExceptionHanlder extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public String ResponseExceptionHandler(ServiceException e, RedirectAttributes redirectAttributes){
        ResultError err = e.getServiceError().getResultError();
        redirectAttributes.addFlashAttribute("ErrorMsg",err.getResultMessage());
        return "redirect:/error";
    }
}
