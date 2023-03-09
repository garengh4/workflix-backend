package com.infy.workflix.utility;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.infy.workflix.dto.FileDTO;
import com.infy.workflix.exception.FileWriteException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
@Component
public class DataBucketUtil {
    @Autowired
    private Storage storage;
    public FileDTO uploadFile(MultipartFile multipartFile, String fileName) {

        try {
            byte[] fileData = FileUtils.readFileToByteArray(convertFile(multipartFile));
            BlobId blobId=BlobId.of("gcp-demo-2023",fileName);
            BlobInfo blobInfo=BlobInfo.newBuilder(blobId).build();
            Blob blob=storage.create(blobInfo, fileData);
            if(blob != null){

                return new FileDTO(blob.getName(), blob.getMediaLink());
            }
        }catch(Exception e) {
            throw new FileWriteException("An error occurred while storing data to GCS");
        }

        return new FileDTO("error","error");
    }

    private File convertFile(MultipartFile file) {

        try{
            if(file.getOriginalFilename() == null){
                throw new FileWriteException("Original file name is null");
            }
            File convertedFile = new File(file.getOriginalFilename());
            FileOutputStream outputStream = new FileOutputStream(convertedFile);
            outputStream.write(file.getBytes());
            outputStream.close();
            return convertedFile;
        }catch (Exception e){
            throw new FileWriteException("An error has occurred while converting the file");
        }
    }

}
