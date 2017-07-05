package servlet;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.io.PrintWriter;  
import java.text.DateFormat;  
import java.util.Date;  
import java.util.List;  
import java.util.UUID;  

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.ProgressListener;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //设置编码  
        request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter pw = response.getWriter();  
        try {  
            //设置系统环境  
            DiskFileItemFactory factory = new DiskFileItemFactory();  
            //文件存储的路径  
            String storePath = getServletContext().getRealPath("/WEB-INF/files");  
            //判断传输方式  form  enctype=multipart/form-data  
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
            if(!isMultipart)  
            {  
                pw.write("传输方式有错误！");  
                return;  
            }  
            ServletFileUpload upload = new ServletFileUpload(factory);  
            upload.setFileSizeMax(4*1024*1024);//设置单个文件大小不能超过4M  
            upload.setSizeMax(4*1024*1024);//设置总文件上传大小不能超过6M  
            //监听上传进度  
            upload.setProgressListener(new ProgressListener() {  
  
                //pBytesRead：当前以读取到的字节数  
                //pContentLength：文件的长度  
                //pItems:第几项  
                public void update(long pBytesRead, long pContentLength,  
                        int pItems) {  
                    System.out.println("已读去文件字节 :"+pBytesRead+" 文件总长度："+pContentLength+"   第"+pItems+"项");  
                      
                }  
            });  
            //解析  
            List<FileItem> items = upload.parseRequest(request);  
            for(FileItem item: items)  
            {  
                if(item.isFormField())//普通字段，表单提交过来的  
                {  
                    String name = item.getFieldName();  
                    String value = item.getString("UTF-8");  
                    System.out.println(name+"=="+value);  
                }else  
                {  
//                  String mimeType = item.getContentType(); 获取上传文件类型  
//                  if(mimeType.startsWith("image")){  
                    InputStream in =item.getInputStream();  
                    String fileName = item.getName();   
                    if(fileName==null || "".equals(fileName.trim()))  
                    {  
                        continue;  
                    }  
                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);  
                    fileName = UUID.randomUUID()+"_"+fileName;  
                      
                    //按日期来建文件夹  
                    String newStorePath = makeStorePath(storePath);  
                    String storeFile = newStorePath+"\\"+fileName;  
                    OutputStream out = new FileOutputStream(storeFile);  
                    byte[] b = new byte[1024];  
                    int len = -1;  
                    while((len = in.read(b))!=-1)  
                    {  
                         out.write(b,0,len);          
                    }  
                    in.close();  
                    out.close();  
                    item.delete();//删除临时文件  
                }  
              }  
//          }  
        }catch(org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException e){   
              //单个文件超出异常  
            pw.write("单个文件不能超过4M");  
        }catch(org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException e){  
            //总文件超出异常  
            pw.write("总文件不能超过6M");  
              
        }catch (FileUploadException e) {  
            e.printStackTrace();  
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
    private String makeStorePath(String storePath) {  
        
        Date date = new Date();  
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);  
        String s = df.format(date);  
        String path = storePath+"\\"+s;  
        File file = new File(path);  
        if(!file.exists())  
        {  
            file.mkdirs();//创建多级目录，mkdir只创建一级目录  
        }  
        return path;  
           
    } 
    private String makeStorePath2(String storePath, String fileName) {  
        int hashCode = fileName.hashCode();  
        int dir1 = hashCode & 0xf;// 0000~1111：整数0~15共16个  
        int dir2 = (hashCode & 0xf0) >> 4;// 0000~1111：整数0~15共16个  
      
        String path = storePath + "\\" + dir1 + "\\" + dir2; // WEB-INF/files/1/12  
        File file = new File(path);  
        if (!file.exists())  
            file.mkdirs();  
      
        return path;  
    } 

}