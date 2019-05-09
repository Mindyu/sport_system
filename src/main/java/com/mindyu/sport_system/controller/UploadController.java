package com.mindyu.sport_system.controller;


import com.mindyu.sport_system.entity.Result;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/img")
public class UploadController {

    @PostMapping("/upload") // 等价于 @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(HttpServletRequest req, @RequestParam("file") MultipartFile file, Model m) {
        //1. 接受上传的文件  @RequestParam("file") MultipartFile file
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss_SSS");
            String originFileName = file.getOriginalFilename();
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            StringBuilder sb = new StringBuilder(originFileName.substring(0, originFileName.lastIndexOf(".")));
            sb.append(sdf.format(new Date()));
            sb.append(originFileName.substring(originFileName.lastIndexOf(".")));
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            // String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + sb.toString();
            String destFileName = System.getProperty("user.home") + File.separator + "server" + File.separator + "uploaded" + File.separator + sb.toString();
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
            m.addAttribute("fileName", sb.toString());
            return new Result(200, "上传成功", sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(500, "上传失败");
    }

    @RequestMapping(value = { "/download" }, method = RequestMethod.GET)
    public Result download(HttpServletResponse response, @RequestParam("filename") String fileName) throws IOException {
        fileName = new String(fileName.getBytes("gbk"), "iso8859-1");   // 防止中文乱码
        String destFileName = System.getProperty("user.home") + File.separator + "server" + File.separator + "uploaded" + File.separator + fileName;
        File file = new File(destFileName);
        if (!file.exists()) return new Result(500, "图片不存在");

        response.addHeader("Content-Disposition", "attachment;fileName=" + destFileName);   // 设置文件名

        byte[] buffer = new byte[1024];
        InputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        OutputStream os = response.getOutputStream();
        int i = bis.read(buffer);
        while (i != -1) {
            os.write(buffer, 0, i);
            i = bis.read(buffer);
        }
        try {
            bis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new Result(200, "");
    }
}
