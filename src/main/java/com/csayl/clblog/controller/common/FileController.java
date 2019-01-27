package com.csayl.clblog.controller.common;

import com.csayl.clblog.config.OSSConfiguration;
import com.csayl.clblog.dto.ResponseData;
import com.csayl.clblog.exception.NoSuchBeanException;
import com.csayl.clblog.model.bo.UserBo;
import com.csayl.clblog.service.UserService;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.FileInputStream;

/**
 * @author: chen
 * @date: 2019/1/22
 **/
@RestController
@RequestMapping("/file")
public class FileController {
    private final UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @Autowired
    public FileController(UserService userService) {
        this.userService = userService;
    }


    /**
     * 上传图片到OSS，若url不为空，则覆盖原图片
     *
     * @param request 请求
     * @return 图片url
     */
    @RequestMapping("/upload")
    public ResponseData<String> uploadToOSS(MultipartHttpServletRequest request) {
        String url = request.getParameter("fileUrl");
        try {
            //修改图片
            if (url != null && !url.isEmpty()) {
                UserBo info = (UserBo) request.getSession().getAttribute("info");
                UserBo userBo = userService.selectSimpleUserByUserId(info.getUser().getUserId());
                //如果和待覆盖的url不相同
                if (!url.equals(userBo.getUser().getUserImageUrl())) {
                    throw new NoSuchBeanException();
                }
                //处理url，得到文件名
                url = url.substring(OSSConfiguration.Domain.length());
            }
            MultipartFile file = request.getFile("file");
            String path = uploadByQiniu((FileInputStream) file.getInputStream(), url);
            return ResponseData.succeed("图片上传成功", path);
        } catch (NoSuchBeanException e) {
            LOGGER.warn("图片上传时", e);
            return ResponseData.fail("请登录自己的账号，重新上传");
        } catch (Exception e) {
            LOGGER.error("图片上传时，", e);
            return ResponseData.fail("图片上传失败");
        }
    }


    /**
     * 上传图片到七牛云
     *
     * @param inputStream 待上传图片
     * @param key         图片名称，若该图片已存在则覆盖
     * @return 图片url
     */
    private String uploadByQiniu(FileInputStream inputStream, String key) throws QiniuException {
        // 构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());

        UploadManager uploadManager = new UploadManager(cfg);

        Auth auth = Auth.create(OSSConfiguration.AccessKey, OSSConfiguration.SecretKey);
        String upToken = auth.uploadToken(OSSConfiguration.Bucket, key);

        Response response = uploadManager.put(inputStream, key, upToken, null, null);
        // 解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

        return OSSConfiguration.Domain + "/" + putRet.key;
    }
}
