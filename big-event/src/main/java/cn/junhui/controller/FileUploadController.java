package cn.junhui.controller;

import cn.junhui.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Name: FileUploadController
 * Package: cn.junhui.controller
 * Description: 文件上传
 *
 * @author Junhui Zhang
 * @Date: 2024/01/26 - 21:10
 * @Version: v1.0
 */

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        // 把文件的内容存储到本地磁盘上
        String originalFilename = file.getOriginalFilename();
        // 保证文件的名字是唯一的，从而防止文件覆盖
        String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        file.transferTo(new File("C:\\Users\\猿\\Desktop\\tmp\\" + filename));
        return Result.success("url访问地址...");
    }
}
