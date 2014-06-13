package cn.upload;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	
	private File uploadImage;

	//上传文件的类型：text/plain
	private String uploadImageContentType;
	
	//上传文件的真是名称
	private String uploadImageFileName;
	
	
	public File getUploadImage() {
		return uploadImage;
	}


	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}


	public String getUploadImageContentType() {
		return uploadImageContentType;
	}


	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}


	public String getUploadImageFileName() {
		return uploadImageFileName;
	}


	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("UploadAction *********** execute()");
		
		ServletContext sc = ServletActionContext.getServletContext();
		
		String path = sc.getRealPath("/fileupload");
		System.out.println(path);
		
		File file = new File(path,uploadImageFileName);
		
		FileUtils.copyFile(uploadImage, file);
		
		uploadImage.delete();
		
		return "success";
	}
	
}
