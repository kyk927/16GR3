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
 * @author ���ÿ�
 *TODO �������ݣ�ҵ����
 *2017��12��5������5:57:28
 */
public class FileAction extends ActionSupport{
	private String userName;
	private File uploadfile;
	
	private String uploadfileFileName;
	private String uploadfileContentType;
	
	private String downfile_name;
	private InputStream downfile_is;
	/**
	 * �����ϴ������ҵ�񷽷�
	 */
	public String upload(){
		if(uploadfile != null){
			try {
				//��ȡ�ϴ��ļ�
				InputStream is = new FileInputStream(uploadfile);
				//�õ��ļ������·��
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file = new File(savePath);
				//�ȴ����ļ���
				if(!file.exists()){
					file.mkdirs();
				}
				//���浽�����������ϴ�������д�뵽savePath���ļ���
				OutputStream os = new FileOutputStream(savePath+"/"+uploadfileFileName);
				//д������
				byte[] buffer = new byte[8096];
				int len = 0;
				while ((len=is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				super.addFieldError("uploadfile", "�ļ�δ�ҵ�");
			} catch (IOException e) {
				e.printStackTrace();
				super.addFieldError("uploadfile", "�ļ�����ʧ��");
			}
		}else{
			super.addFieldError("uploadfile", "�ϴ�ʧ��");
		}
		return "uploadSuccess";
	}
	/**
	 * �������������ҵ�񷽷�
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
