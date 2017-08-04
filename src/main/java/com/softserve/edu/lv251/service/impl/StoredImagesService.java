package com.softserve.edu.lv251.service.impl;

import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Added by Pavlo Kuchereshko.
 *
 */
public class StoredImagesService {

    public static String getDefaultPictureBase64encoded(String filename) {
        //Get file from resources folder
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(new ClassPathResource(filename).getURI()));
            return new String(Base64.encode(bytes), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getBase64encodedMultipartFile(MultipartFile file) {
        //Get file from resources folder
        try {
            byte[] bytes = file.getBytes();
            return new String(Base64.encode(bytes), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
