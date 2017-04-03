package action.auction;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Part;
import java.io.File;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by Dymond on 2017/4/3.
 */

public class UploadImgAction extends ActionSupport {

    private String user_name;


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String execute() throws Exception {
        //建立用户对应图片文件夹
        String real_path = ServletActionContext.getServletContext().getRealPath("/img/userImg/" + user_name);
        System.out.println("realpath:" + real_path);
        Part part = ServletActionContext.getRequest().getPart("upload");

        //文件类型限制
        String[] allowedType = {"image/bmp", "image/gif", "image/jpeg", "image/png"};
        boolean allowed = Arrays.asList(allowedType).contains(part.getContentType());
        if (!allowed) {
            ServletActionContext.getResponse().getWriter().write("error|不支持的类型");
        }
        //图片大小限制
        if (part.getSize() > 5 * 1024 * 1024) {
            ServletActionContext.getResponse().getWriter().write("error|图片大小不能超过5M");
        }

        String fi = part.getHeader("content-disposition");
        String fileNameExtension = fi.substring(fi.indexOf("."), fi.length() - 1);
        //UUID+扩展文件名
        String realName = UUID.randomUUID().toString() + fileNameExtension;
        String filePath = real_path + "/" + realName;
        part.write(filePath);

        ServletActionContext.getResponse().getWriter().write(filePath);

        return SUCCESS;

    }
}
