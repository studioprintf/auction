package action;

import java.io.PrintWriter;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	
	private String contentType = "text/html;charset=utf-8";     
    public String execute() throws Exception
    {
        //指定输出内容类型和编码  
        ServletActionContext.getResponse().setContentType(contentType);   
        //获取输出流，然后使用  
        PrintWriter out = ServletActionContext.getResponse().getWriter();   
        try{  
            //输出文本信息  
            out.print("Hello World");  
            out.print("Time: " + (new Date()).getTime());   
            out.flush();  
            out.close();  
        }catch(Exception ex){  
            out.println(ex.toString());  
        }
        return SUCCESS;  
    }
}
