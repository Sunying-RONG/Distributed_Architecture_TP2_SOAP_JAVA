package MainPackage;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL url = new URL("http://localhost:8080/mathservice?wsdl");
		
		ClientPackage.MathServiceImplService MathServiceImpl = 
				new ClientPackage.MathServiceImplService(url);
		
		ClientPackage.IMathService proxy = 
				MathServiceImpl.getMathServiceImplPort();	
		System.out.print(proxy.add(1, 2));
		
		byte[] image = proxy.downloadImage("ReginaDouble.jpg");
		JFrame imageFrame = new JFrame();
        imageFrame.setSize(400, 400);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageFrame.add(imageLabel);
        imageFrame.setVisible(true);
	}

}
