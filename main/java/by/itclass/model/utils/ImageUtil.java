package by.itclass.model.utils;

import by.itclass.model.beans.Image;

import java.io.*;

public class ImageUtil {

    public static void createImageFile(String path, Image image) {
        File imageFile = new File(path+ File.separator + image.getName());
        try {
            if (!imageFile.exists()) {
                imageFile.createNewFile();

                try (OutputStream out = new FileOutputStream(imageFile)) {
                    out.write(image.getContent());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image getImage(String path, String name){
        Image image = null;
        try(InputStream in = new FileInputStream(path + File.separator + name)){
            byte[] content = in.readAllBytes();
            image = new Image(name, content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
