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
 * ���ã�Ѱ��ʧ��Servlet��
 */

public class LostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			//��ñ������ж���Ԫ��
			Lost lost = new Lost();
			
			//ʵ�����ļ��ϴ��Ĺ�����
			DiskFileItemFactory factory=new DiskFileItemFactory();
			
			//�����ļ��ϴ���ServletFileUploadʵ������
			ServletFileUpload upload=new ServletFileUpload(factory);
			
			//����ServletFileUpload�������request����
			List<FileItem> item=upload.parseRequest(request);
			
			//�������е�item
			for (FileItem fileItem : item) {
				//����FileItem.isFormField�ж�����ͨ����ϴ���
				if(fileItem.isFormField()){
					// ����ͨ��
					//�����ͨ�����Ŀ��
					String fieldname = fileItem.getFieldName();
					
					//�����ͨ�������
					String fieldvalue = fileItem.getString("utf-8");
					
					// ͨ����Ԫ�������ж�,��װJavaBean
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
					//�ϴ��ļ�
					//���ϴ��ļ����浽��������
					//����ļ���
					String fileName=fileItem.getName();
					
					
					if(fileName!=null){
						//����ļ�ͬ����������
						fileName=UUID.randomUUID()+fileName.substring(fileName.lastIndexOf('.'), fileName.length());
						
						//����һ��������
						InputStream in=fileItem.getInputStream();
						
						//��ô��·��
						String path = getServletContext().getRealPath("/Upload");
						
						//����һ�������
						OutputStream outf=new FileOutputStream(new File(path,fileName));
						
						//����
						IOUtils.copy(in, outf);
						
						//��װ�ļ���
						lost.setPhoto("Upload/"+fileName);
						
						//�ر�����Դ
						in.close();
						
						outf.close();
						
					}
				}
				
			}
			
			//���������
			FindAndLostService service = new FindAndLostServiceImpl();
			
			//�ѷ�װ�����ݴ��������
			boolean flag = service.find(lost);
			
			//�����ɹ�
			if(flag){
				//��ת����ҳ��
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else{
				//��ʾ�û��������ɹ�
				request.setAttribute("error_msg", "ʧ�ﴴ��ʧ�ܣ�����´�����");
				//�������ɹ����������ʧ��ҳ��
				request.getRequestDispatcher("/lostProperty.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
