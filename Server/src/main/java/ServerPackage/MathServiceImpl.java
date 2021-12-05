package ServerPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

@WebService(endpointInterface="ServerPackage.IMathService")
@MTOM(threshold=10)
public class MathServiceImpl implements IMathService {
	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}
	
	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public int divide(int a, int b) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (b == 0) {
			throw new IllegalArgumentException("Error: Cannot divide by zero");
		} else {
			return a / b;
		}
	}
	
//	@Override
//    public String uploadImage(Image imageData) {
//        if(null != imageData){
//            //Write a code to store the image
//            return "Image uploaded successfully";
//        }
//        //If image data is not there, then throw below exception
//        throw new WebServiceException("Image Upload Failed!");
//    }
	
	@Override
	public Image downloadImage(String imageName) {
        File image = new File("src/main/java/ServerPackage/images/"+imageName);
        try {
            return ImageIO.read(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	

}
