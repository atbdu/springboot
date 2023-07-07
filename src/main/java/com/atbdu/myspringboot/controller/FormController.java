package com.atbdu.myspringboot.controller;

import com.atbdu.myspringboot.exception.FilesToManyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FormController {
    private static final Logger log = LogManager.getLogger();
    @GetMapping("/toUpload")
    public String toUpload(){
        System.out.println("88888888888");
        return "views/success";
    }
    @PostMapping("/upload")
    public String UploadFiles(@RequestParam(name = "description" ) String description,
                              @RequestPart("oneFile") MultipartFile file,@RequestPart("twoFile") MultipartFile[] files) throws IOException {
        log.info("文件上传了","文件描述："+description,"文件名称："+file.getName()+"文件大小："+file.getSize(),"文件长度"+files.length);
        if (!file.isEmpty()){
            String path = file.getOriginalFilename();
            if (path.substring(path.lastIndexOf(".")+1).equals("txt")){
                file.transferTo(new File("E:\\temp\\"+path));
            }else{
                return "views/fail";
            }

        }
        if (files.length>0){
            if(files.length>=3){
                throw new FilesToManyException("这是我自定义的异常文件");
            }
            for (MultipartFile oneFile : files){
                if (!oneFile.isEmpty()){
                    String pathFile = oneFile.getOriginalFilename();
                    oneFile.transferTo(new File("E:\\temp\\"+pathFile));
                }
            }
        }
        return "redirect:/";
    }
}
