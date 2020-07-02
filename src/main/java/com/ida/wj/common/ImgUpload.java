package com.ida.wj.common;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lh
 * @date 2020/5/20
 * @description 图片上传
 */
@RestController
public class ImgUpload {
    @RequestMapping(value = "/api/upload",method = RequestMethod.POST)
    @CrossOrigin
    public String upload(@RequestParam MultipartFile file){
        String relativePath = "static\\img\\demobook\\";
        String filePath = "E:\\springbootproject\\wj-vue-test\\"+relativePath;
        File newFile = new File(filePath);
        if (!newFile.exists()){
            newFile.mkdirs();
        }
        SimpleDateFormat sdfformat = new SimpleDateFormat("YYYYMMddHHMMss");
        String fileName = sdfformat.format(new Date())+".jpg";
        File targetFile  = new File(filePath+fileName);
        try{
            file.transferTo(targetFile);

        }catch (Exception e){

        }
        return relativePath+fileName;

    }
    public void download(){

    }
}
