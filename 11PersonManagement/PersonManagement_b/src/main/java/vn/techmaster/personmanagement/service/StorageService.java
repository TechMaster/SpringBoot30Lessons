package vn.techmaster.personmanagement.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.personmanagement.exception.StorageException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service

//Anh upload len thu muc photos trong folder photos va duoc ket noi voi thu muc src/main/resources/static/photos
//Vi khi ta upload anh vao thu muc static se khong luu ngay ma can restart lai spring boot nen se upload o thu muc khac
public class StorageService {
    @Value("${upload.path}")
    private String path;
    public void uploadFile(MultipartFile file, int id) throws Exception {
        if(file.isEmpty()){
            throw new StorageException("Failed to store empty file");
        }
        String fileName = file.getOriginalFilename();
        try{
            var is = file.getInputStream();
            Files.copy(is, Paths.get(path + id + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            var msg = String.format("Failed to store file %s",fileName);
            throw new StorageException(msg,e);
        }
    }
}
