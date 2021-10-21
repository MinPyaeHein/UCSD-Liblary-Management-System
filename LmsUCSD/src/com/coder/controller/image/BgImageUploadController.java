package com.coder.controller.image;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.util.PrjSubFunction;
import com.coder.util.ServerPath;


@Controller
@Transactional
public class BgImageUploadController {

	@RequestMapping("/bgimageUploadPath")
	public void bgimageUploadDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		String frmProductId=req.getParameter("frmImageId");
		int imgId=0;
		if(frmProductId.startsWith("SID")){
			imgId=PrjSubFunction.convertId(frmProductId,"SID");
		}else if(frmProductId.startsWith("TID")){
			imgId=PrjSubFunction.convertId(frmProductId,"TID");
		}else if(frmProductId.startsWith("ID")){
			imgId=PrjSubFunction.convertId(frmProductId,"ID");
		}else{
			imgId=Integer.parseInt(frmProductId.trim());
		}
		String frmType=req.getParameter("frmType");
		String fileName=imgId+".jpg";
		String serverPath=ServerPath.getPath();
		System.out.println("serverPath="+serverPath);
		if(frmType.equals("student")){
			serverPath+=File.separator+"student";
		}else if(frmType.equals("teacher")){
			serverPath+=File.separator+"teacher";
		}else if(frmType.equals("book")){
			serverPath+=File.separator+"book";
		}else if(frmType.equals("admin")){
			serverPath+=File.separator+"admin";
		}
		
        Path file = Paths.get(serverPath,fileName);
      
        
        if (Files.exists(file)) 
        { try
        {
        	System.out.println(file.toString());
            Files.copy(file, resp.getOutputStream());
            resp.setContentType(MediaType.IMAGE_JPEG_VALUE);
            resp.getOutputStream().flush();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
        }else{
        
        file = Paths.get(serverPath,"default.png");
    	try {
			Files.copy(file, resp.getOutputStream());
		    resp.setContentType(MediaType.IMAGE_JPEG_VALUE);
	        resp.getOutputStream().flush();
	        
		} catch (IOException e) {
				e.printStackTrace();
		}
        }
	}
	
	
	
}
