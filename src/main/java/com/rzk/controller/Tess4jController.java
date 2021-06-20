package com.rzk.controller;

import com.rzk.response.Result;
import io.swagger.annotations.ApiOperation;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @PackageName : com.rzk
 * @FileName : Tess4jController
 * @Description :
 * @Author : rzk
 * @CreateTime : 20/6/2021 下午5:03
 * @Version : 1.0.0
 */
@RestController
@RequestMapping(("com/rzk/"))
public class Tess4jController {
    public static final String datapath = "tessdata";

    @PostMapping("/file")
    @ApiOperation(httpMethod = "POST",value = "上传图片")
    public Result fileController(@RequestParam("file")MultipartFile file ) throws IOException, TesseractException {
        ITesseract instance =new Tesseract();

        //如果未将tessdata放在根目录下需要指定绝对路径
//        instance.setDatapath("/");
        //instance.setDatapath("the absolute path of tessdata");

        //如果需要识别英文之外的语种，需要指定识别语种，并且需要将对应的语言包放进项目中

        instance.setLanguage("chi_sim");

        // 指定识别图片
        File imgDir = new File(file.getOriginalFilename());
        System.out.println(imgDir.exists());
        long startTime = System.currentTimeMillis();

        String ocrResult = instance.doOCR(imgDir);

        // 输出识别结果
        System.out.println("OCR Result: \n" + ocrResult +"\n 耗时：" + (System.currentTimeMillis() - startTime) +"ms");
        return new Result(200,null,ocrResult);
    }


}
