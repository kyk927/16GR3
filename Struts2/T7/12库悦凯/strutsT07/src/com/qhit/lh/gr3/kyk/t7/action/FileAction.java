/**
 * 
 */
package com.qhit.lh.gr3.kyk.t7.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 库悦凯
 *TODO 保存数据，业务处理
 *2017年12月5日下午5:57:28
 */
public class FileAction extends ActionSupport{
	private String userName;
	private File uploadfile;
	
	private String uploadfileFileName;
	private String uploadfileContentType;
	
	private String downfile_name;
	private InputStream downfile_is;
	/**
	 * 处理上传请求的业务方法
	 */
	public String upload(){
		if(uploadfile != null){
			try {
				//读取上传文件
				InputStream is = new FileInputStream(uploadfile);
				//得到文件保存的路径
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file = new File(savePath);
				//先创建文件夹
				if(!file.exists()){
					file.mkdirs();
				}
				//保存到服务器：将上传的内容写入到savePath的文件中
				OutputStream os = new FileOutputStream(savePath+"/"+uploadfileFileName);
				//写入数据
				byte[] buffer = new byte[8096];
				int len = 0;
				while ((len=is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				super.addFieldError("uploadfile", "文件未找到");
			} catch (IOException e) {
				e.printStackTrace();
				super.addFieldError("uploadfile", "文件保存失败");
			}
		}else{
			super.addFieldError("uploadfile", "上传失败");
		}
		return "uploadSuccess";
	}
	/**
	 * 处理下载请求的业务方法
	 */
	public String download(){
		if(downfile_name != null){
			
			try {
				String destfile = ServletActionContext.getServletContext().getRealPath("/")+"upload/"+downfile_name;
				downfile_is = new FileInputStream(destfile);
				return "down";
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public File getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getUploadfileFileName() {
		return uploadfileFileName;
	}
	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}
	public String getUploadfileContentType() {
		return uploadfileContentType;
	}
	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}
	public String getDownfile_name() {
		return downfile_name;
	}
	public void setDownfile_name(String downfile_name) {
		this.downfile_name = downfile_name;
	}
	public InputStream getDownfile_is() {
		return downfile_is;
	}
	public void setDownfile_is(InputStream downfile_is) {
		this.downfile_is = downfile_is;
	}
	
	
}
