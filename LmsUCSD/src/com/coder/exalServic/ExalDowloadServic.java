package com.coder.exalServic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service
@Repository("exalDowloadServic")
public class ExalDowloadServic {
	   public void doDownload(HttpServletRequest request,
           HttpServletResponse response,String filePath) throws IOException {
		   System.out.println("Arriving Dowload");
       	  int BUFFER_SIZE = 4096;
           // get absolute path of the application
           ServletContext context = request.getServletContext();
           String appPath = context.getRealPath("");
           System.out.println("appPath = " + appPath);
    
           // construct the complete absolute path of the file
           String fullPath = appPath + filePath;      
           File downloadFile = new File(fullPath);
           FileInputStream inputStream = new FileInputStream(downloadFile);
            
           // get MIME type of the file
           String mimeType = context.getMimeType(fullPath);
           if (mimeType == null) {
               // set to binary type if MIME mapping not found
               mimeType = "application/octet-stream";
           }
           System.out.println("MIME type: " + mimeType);
    
           // set content attributes for the response
           response.setContentType(mimeType);
           response.setContentLength((int) downloadFile.length());
    
           // set headers for the response
           String headerKey = "Content-Disposition";
           String headerValue = String.format("attachment; filename=\"%s\"",
                   downloadFile.getName());
           System.out.println("downloadFile.getName()="+downloadFile.getName());
           response.setHeader(headerKey, headerValue);
    
           // get output stream of the response
           OutputStream outStream = response.getOutputStream();
    
           byte[] buffer = new byte[BUFFER_SIZE];
           int bytesRead = -1;
    
           // write bytes read from the input stream into the output stream
           while ((bytesRead = inputStream.read(buffer)) != -1) {
               outStream.write(buffer, 0, bytesRead);
           }
    
           inputStream.close();
           outStream.close();
       }
}
