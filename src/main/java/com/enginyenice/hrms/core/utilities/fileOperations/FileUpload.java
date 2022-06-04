package com.enginyenice.hrms.core.utilities.fileOperations;

import org.springframework.web.multipart.MultipartFile;

public interface FileUpload {
    String upload(MultipartFile file);
}
