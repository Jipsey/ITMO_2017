package Coursera;

import edu.duke.*;
public class GrayScaleConverter
{
    
    public ImageResource makeGray (ImageResource inImage){
    ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
      for(Pixel pixel:outImage.pixels()){
         Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY()); 
         int avarage = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
         pixel.setRed(avarage);
         pixel.setGreen(avarage);
         pixel.setBlue(avarage);
        }
        return outImage;
    }
public void testGray(){
ImageResource ir = new ImageResource();
ImageResource gray = makeGray(ir);
gray.draw();
}

}
