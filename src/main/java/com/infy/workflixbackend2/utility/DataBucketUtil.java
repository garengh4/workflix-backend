package com.infy.workflixbackend2.utility;



import com.google.cloud.storage.*;
import com.infy.workflixbackend2.dto.FileDTO;
import com.infy.workflixbackend2.exception.FileWriteException;
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

        throw new FileWriteException("An error occurred while storing data to GCS");
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

    public String updateFile(String oldFileName, String newFileName){
        BlobId source=BlobId.of("gcp-demo-2023",oldFileName);
        BlobId target=BlobId.of("gcp-demo-2023",newFileName);
        Storage.BlobTargetOption precondition;
        if(storage.get("gcp-demo-2023", newFileName)==null){
            precondition=Storage.BlobTargetOption.doesNotExist();
        }else {
            precondition = Storage.BlobTargetOption.generationMatch(
                    storage.get("gcp-demo-2023", newFileName).getGeneration());
        }
        storage.copy(
                Storage.CopyRequest.newBuilder().setSource(source).setTarget(target, precondition).build());
        Blob copiedObject =storage.get(target);
        storage.get(source).delete();
        return copiedObject.getMediaLink();
    }
    public String deleteFile(String fileName){
        BlobId blob=BlobId.of("gcp-demo-2023",fileName);
        boolean deleted=storage.delete(blob);
        if(!deleted){
            throw new FileWriteException("An error has occurred while deleting the file");
        }
        return " delete successfully";
    }

}
