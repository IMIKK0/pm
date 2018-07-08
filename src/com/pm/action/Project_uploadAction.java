package com.pm.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.bean.Project_upload;
import com.pm.service.ServiceUtil;
import com.pm.util.PageUtiles;
@Controller
public class Project_uploadAction extends ActionSupport {
	@Resource
	private ServiceUtil<Project_upload> project_uploadService;
	private PageUtiles page;
	private String num;
	private Project_upload project_upload;
	private File myfile;
	private String myfileFileName;
	private String filename;
	private List<Project_upload> listUpload;
	public String add(){
		
		return "add";
	}	
	/**
	 * 下载文件
	 * @return InputStream
	 * @throws UnsupportedEncodingException
	 */
	public InputStream getDownloadFile() throws UnsupportedEncodingException{
		filename=new String(filename.getBytes("ISO8859-1"),"utf-8");
		String realPath="/file/"+filename;
		System.out.println(realPath);
		return ServletActionContext.getServletContext().getResourceAsStream(realPath);
	}
	/**
	 * 上传文件
	 * @return uploadFile
	 */
	public String uploadFile(){	
		String upload=ServletActionContext.getServletContext().getRealPath("/file");
		File f=new File(upload);
		if(!f.exists()){
			f.mkdirs();
		}
		File file2=new File(upload, myfileFileName);
		try {
			FileUtils.copyFile(myfile,file2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(myfileFileName);
		project_upload.setUp_filename(myfileFileName);		
		project_uploadService.save(project_upload);
		return "insert_success";
	}
	public String findAll(){
		System.out.println(000);
		int pageNum = 1;
		if(num!=null){
			pageNum = Integer.parseInt(num);
		}
		//总条数
		int totalRecordsNumber = project_uploadService.totalCount();
		page= new PageUtiles(pageNum, totalRecordsNumber);
		listUpload = project_uploadService.findAll(page.getStartIndex(), page.getPageSize());
		return "findAll";		
	}
	public PageUtiles getPage() {
		return page;
	}
	public void setPage(PageUtiles page) {
		this.page = page;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Project_upload getProject_upload() {
		return project_upload;
	}
	public void setProject_upload(Project_upload project_upload) {
		this.project_upload = project_upload;
	}
	public File getMyfile() {
		return myfile;
	}
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	public String getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public List<Project_upload> getListUpload() {
		return listUpload;
	}
	public void setListUpload(List<Project_upload> listUpload) {
		this.listUpload = listUpload;
	}
	
	
}
