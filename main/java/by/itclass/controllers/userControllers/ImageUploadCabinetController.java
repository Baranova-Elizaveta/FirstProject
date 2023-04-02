package by.itclass.controllers.userControllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.beans.Image;
import by.itclass.model.beans.User;
import by.itclass.model.enums.ImageAction;
import by.itclass.model.utils.ImageUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ImageUploadCabinetController", value = AppConstant.UPLOAD_IMAGE_CABINET_CONT_URL)
public class ImageUploadCabinetController extends AbstractUserController {
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       User user = (User) session.getAttribute(AppConstant.USER_ATTR);


       File repository = new File(AppConstant.IO_TEMP_REPOSITORY);

       DiskFileItemFactory factory = new DiskFileItemFactory();
       factory.setRepository(repository);

       ServletFileUpload servlet = new ServletFileUpload(factory);
       try {
           List<FileItem> items = servlet.parseRequest(request);
           if(items.size()>0){
               FileItem fileItem = items.get(0);
               Image image = new Image(fileItem.getName(), fileItem.getInputStream().readAllBytes());
               user.setImage(image);
               userDAO.saveImage(user, ImageAction.UPDATE);
               ImageUtil.createImageFile(getServletContext().getRealPath(AppConstant.IMAGE_FOLDER_NAME),image);
           }
       } catch (FileUploadException e) {
           e.printStackTrace();
       }
        redirect(response,AppConstant.CABINET_JSP);
   }
}
