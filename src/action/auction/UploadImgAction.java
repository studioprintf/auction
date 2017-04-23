package action.auction;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by Dymond on 2017/4/3.
 */
public class UploadImgAction extends ActionSupport {

    private String user_name;
    private File publishImg;
    private String publishImgContentType;
    private String publishImgFileName;
    private InputStream inputStream;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public File getPublishImg() {
        return publishImg;
    }

    public void setPublishImg(File publishImg) {
        this.publishImg = publishImg;
    }

    public String getPublishImgContentType() {
        return publishImgContentType;
    }

    public void setPublishImgContentType(String publishImgContentType) {
        this.publishImgContentType = publishImgContentType;
    }

    public String getPublishImgFileName() {
        return publishImgFileName;
    }

    public void setPublishImgFileName(String publishImgFileName) {
        this.publishImgFileName = publishImgFileName;
    }

    @Override
    public String execute() throws Exception {
        //建立用户对应图片文件夹
        int t = 0;// 0用于处理离散上传，1用于富媒体框架上传
        String real_path;
        if (user_name == null) {//离散文件
            real_path = ServletActionContext.getServletContext().getRealPath("/img/product");
        } else {//富媒体框架,放在user_name单独文件夹内，不存在则创建
            t = 1;
            real_path = new String(ServletActionContext.getServletContext().getRealPath("/img/userImg/" + user_name));
            File f = new File(real_path);
            if (!(f.isDirectory())) {
                f.mkdirs();
            }
        }


        if (publishImg == null) {
            inputStream = new ByteArrayInputStream("error|服务器错误".getBytes("UTF-8"));
        } else {
            String fileNameExtension = (publishImgFileName.substring(publishImgFileName.lastIndexOf("."), publishImgFileName.length())).toLowerCase();
            //文件类型限制
            String[] allowedType = {".bmp", ".gif", ".jpeg", ".png", ".jpg"};

            boolean allowed = Arrays.asList(allowedType).contains(fileNameExtension);
            if (!allowed) {
                inputStream = new ByteArrayInputStream("error|不支持的类型".getBytes("UTF-8"));
            } else {

//UUID+扩展文件名
                String realName = UUID.randomUUID().toString() + fileNameExtension;
                String filePath = real_path + "/" + realName;
                File imageFile = new File(filePath);
                System.out.println(filePath);
                org.apache.commons.io.FileUtils.copyFile(publishImg, imageFile);

                String netPath;
                if (t == 1) {
                    netPath = ServletActionContext.getRequest().getContextPath() + "/img/userImg/" + user_name + '/' + realName;
                } else {//t==0
                    netPath = ServletActionContext.getRequest().getContextPath() + "/img/product/" + realName;
                }

                inputStream = new ByteArrayInputStream(netPath.getBytes("UTF-8"));
            }
//        }

        }
        return SUCCESS;
    }
}
