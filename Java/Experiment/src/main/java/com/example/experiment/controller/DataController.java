package com.example.experiment.controller;

import com.example.experiment.ZipDownloadUtil;
import com.example.experiment.entity.Something;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能实现
 *
 * @author lltt9
 * @date 2022-12-27 20:04
 */
@RestController
public class DataController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);

    /**
     * 测试reuqest获取路径参数
     */
    @GetMapping(value = {"/get/data/{id}/{name}", "/get/data/{name}"})
    public String getData(@PathVariable(value = "id", required = true) String id, @PathVariable("name") String name) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        return "123";
    }

    @GetMapping("/data")
    public String getDataTwo(@RequestParam(value = "id", required = false, defaultValue = "123") String id, @RequestParam("name") String name) {
        System.out.println(id);
        System.out.println(name);
        return name;
    }

    @PostMapping(value = "/get/data/post", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List postData(@RequestBody List<Something> list) {
        Something something = list.get(0);
        List<Something.Pop> poplist = something.getPoplist();
        return poplist;
    }

    /**
     * 批量上传文件
     *
     * @param files
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/upload")
    public String upLoadFile(@RequestParam List<MultipartFile> files) throws IOException {
        files.stream().forEach(s -> {
            String originalFilename = s.getOriginalFilename();
            System.out.println("s.getOriginalFilename() = " + s.getOriginalFilename());
            System.out.println("s.getName() = " + s.getName());
            System.out.println("s.getSize() = " + s.getSize());
            String path = "D://";
            File file1 = new File(path + originalFilename);
            System.out.println(path + originalFilename);
            try {
                s.transferTo(file1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return "上传成功";

    }

    /**
     * 单个下载文件
     */
    @GetMapping(value = "/download", produces = "image/*")
    public void downLoadFile(HttpServletResponse response) throws IOException {
        String path = "D://";
        File file = new File(path + "OIP-C.jpg");
        InputStream is = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("OIP-C.jpg", "UTF-8"));
        IOUtils.copy(is, outputStream);
    }

    /**
     * 批量下载文件(打包)
     */
    @GetMapping("/batchdownload")
    public String batchDownLoadFile(HttpServletResponse response) throws FileNotFoundException {
        List<File> files = new ArrayList<>();
        files.add(new File("D:\\新建 文本文档.txt"));
        ZipDownloadUtil.zipDownload(response, "demo.zip", files);
        return "download success";
    }


}
