package com.softserve.edu.lv251.service.impl;

import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.codec.Base64;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class StoredImagesService {

    static String getDefaultPictureBase64encoded(String filename) {
        //Get file from resources folder
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(new ClassPathResource(filename).getURI()));
            return new String(Base64.encode(bytes), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
