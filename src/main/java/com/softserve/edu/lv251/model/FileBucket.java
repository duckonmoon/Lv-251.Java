package com.softserve.edu.lv251.model;

import com.softserve.edu.lv251.customannotations.ValidFile;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * Created by Admin on 04.08.2017.
 */
@ValidFile
public class FileBucket {

    private MultipartFile multipartFile;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

}
