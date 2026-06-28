/*
 * package com.springboot.api.book.helper;
 * 
 * import java.io.File; import java.nio.file.Files; import java.nio.file.Paths;
 * import java.nio.file.StandardCopyOption;
 * 
 * import org.springframework.stereotype.Component; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * @Component public class FileUploadHelper { public final String UPLOAD_DIR=
 * "C:\\SpringBoot\\Spring-Boot\\bookrestbook\\src\\main\\resources\\static\\Images";
 * 
 * public boolean uploadFile(MultipartFile multiPartFile) { boolean f = false;
 * 
 * try {
 * 
 * // InputStream is =multiPartFile.getInputStream(); // byte[] data = new
 * byte[is.available()]; // is.read(); // // //Write // FileOutputStream fos =
 * new
 * FileOutputStream(UPLOAD_DIR+File.separator+multiPartFile.getOriginalFilename(
 * )); // fos.write(data); // fos.flush(); // fos.close();
 * 
 * Files.copy(multiPartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator
 * +multiPartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
 * f=true;
 * 
 * } catch (Exception e) { e.printStackTrace(); } return f; }
 * 
 * }
 */

package com.springboot.api.book.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public static final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/Images";

    public boolean uploadFile(MultipartFile multiPartFile) throws IOException {

       
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        
        Files.copy(
            multiPartFile.getInputStream(),
            Paths.get(UPLOAD_DIR + File.separator + multiPartFile.getOriginalFilename()),
            StandardCopyOption.REPLACE_EXISTING
        );

        return true; 
    }
}