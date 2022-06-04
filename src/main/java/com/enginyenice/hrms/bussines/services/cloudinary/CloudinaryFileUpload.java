package com.enginyenice.hrms.bussines.services.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.enginyenice.hrms.core.utilities.fileOperations.FileUpload;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Component
@Qualifier("cloudinary")
public class CloudinaryFileUpload implements FileUpload {

    @Value("${cloudinary.cloud.name}")
    private String cloudName;
    @Value("${cloudinary.api.key}")
    private String apiKey;
    @Value("${cloudinary.api.secret.key}")
    private  String apiSecret;
    private Cloudinary cloudinary;
    public CloudinaryFileUpload() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }

    @Override
    public String upload(MultipartFile file) {
        try {
            Map upload = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
            System.out.println(upload.get("url"));
            return upload.get("url").toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
