package com.oyc.ExceptionHandler;

import ognl.IntHashMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Map<String, Object> allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception{

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);
        map.put("errorMsg", exception.getMessage());
        return map;
        // fafngskgv
    }
}
