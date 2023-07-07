package com.atbdu.myspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "上传文件过多")
public class FilesToManyException extends RuntimeException {
    public FilesToManyException() {
    }

    public FilesToManyException(String message) {
        super(message);
    }

}
