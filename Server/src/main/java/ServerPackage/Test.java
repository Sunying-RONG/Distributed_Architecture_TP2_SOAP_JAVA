package ServerPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {

	public static void main(String[] args) {
		System.out.println(new File("src/main/java/ServerPackage/images/ReginaDouble.jpg").getAbsolutePath());
		downloadImage("ReginaDouble.jpg");
	}
	
	public static Image downloadImage(String imageName) {
        File image = new File("src/main/java/ServerPackage/images/"+imageName);
        try {
            return ImageIO.read(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
