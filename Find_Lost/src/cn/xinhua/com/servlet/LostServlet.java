package cn.xinhua.com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;


import cn.xinhua.com.modal.Lost;
import cn.xinhua.com.service.FindAndLostService;
import cn.xinhua.com.service.Impl.FindAndLostServiceImpl;

/*
 * 作用：寻找失物Servlet层
 */

public class LostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			//获得表单中所有对象元素
			Lost lost = new Lost();
			
			//实例化文件上传的工厂类
			DiskFileItemFactory factory=new DiskFileItemFactory();
			
			//创建文件上传的ServletFileUpload实例对象
			ServletFileUpload upload=new ServletFileUpload(factory);
			
			//利用ServletFileUpload对象解析request对象
			List<FileItem> item=upload.parseRequest(request);
			
			//遍历所有的item
			for (FileItem fileItem : item) {
				//利用FileItem.isFormField判断是普通项还是上传项
				if(fileItem.isFormField()){
					// 是普通项
					//获得普通项的项目名
					String fieldname = fileItem.getFieldName();
					
					//获得普通项的内容
					String fieldvalue = fileItem.getString("utf-8");
					
					// 通过表单元素名称判断,封装JavaBean
					if(fieldname.equals("thing")){
						lost.setThing(fieldvalue);
					}else if(fieldname.equals("date")){
						lost.setTime(fieldvalue);
					}else if(fieldname.equals("where")){
						lost.setWhere(fieldvalue);
					}else if(fieldname.equals("phone")){
						lost.setPhone(fieldvalue);
					}else if(fieldname.equals("description")){
						lost.setDescription(fieldvalue);
					}
				}else{
					//上传文件
					//将上传文件保存到服务器中
					//获得文件名
					String fileName=fileItem.getName();
					
					
					if(fileName!=null){
						//解决文件同名覆盖问题
						fileName=UUID.randomUUID()+fileName.substring(fileName.lastIndexOf('.'), fileName.length());
						
						//创建一个输入流
						InputStream in=fileItem.getInputStream();
						
						//获得存放路径
						String path = getServletContext().getRealPath("/Upload");
						
						//创建一个输出流
						OutputStream outf=new FileOutputStream(new File(path,fileName));
						
						//放行
						IOUtils.copy(in, outf);
						
						//封装文件项
						lost.setPhoto("Upload/"+fileName);
						
						//关闭流资源
						in.close();
						
						outf.close();
						
					}
				}
				
			}
			
			//创建服务层
			FindAndLostService service = new FindAndLostServiceImpl();
			
			//把封装的数据传到服务层
			boolean flag = service.find(lost);
			
			//创建成功
			if(flag){
				//跳转到主页面
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else{
				//提示用户创建不成功
				request.setAttribute("error_msg", "失物创建失败！请从新创建！");
				//创建不成功，返回添加失物页面
				request.getRequestDispatcher("/lostProperty.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
