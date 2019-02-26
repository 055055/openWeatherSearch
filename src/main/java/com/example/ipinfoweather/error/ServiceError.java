package com.example.ipinfoweather.error;

import com.example.ipinfoweather.dto.ResultError;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

public enum ServiceError {
   CITY_NOT_FOUND(){
       @Override
       public ResultError getResultError() {
           String message = getMessage();
           return ResultError.builder()
                   .httpStatus(HttpStatus.NOT_FOUND)
                   .resultCode("40000")
                   .resultMessage(StringUtils.isEmpty(message) ? "City Not Found" : message)
                   .build();
       }
   },

   INTERNAL_SERVCER_ERROR(){
       @Override
       public ResultError getResultError() {
           String message = getMessage();
           return ResultError.builder()
                   .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                   .resultCode("50000")
                   .resultMessage(StringUtils.isEmpty(message) ? "INTERNAL_SERVER_ERROR" : message)
                   .build();
       }
   }
    ;

       private String message;

       public abstract ResultError getResultError();

       public String getMessage() {
           return message;
       }

       public void setMessage(String message) {
           this.message = message;
       }


}
