package imageScrambler.image_encrypt;
 
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
 
public class E1_encrypt
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File output_file=new File("D:/pixels.txt");                   //Chiquvchi matn fayl
        PrintStream out=new PrintStream(new FileOutputStream(output_file));
        System.setOut(out);
      
        BufferedImage image = readImage("D:/sarf1.jpg");               //Kiruvchi tasvir
        printAllARGBDetails(image);
    }
 
    public static void printAllARGBDetails(BufferedImage image)
    {
        int width = image.getWidth();
        int height = image.getHeight();
        int pix_num=1;
        int total_pix=width*height;
        System.out.println("--------------------------------------------");   
        System.out.println("Tasvir o'lchamlari: Bo'yi-" + height + ", Eni-" + width);
        System.out.println("Umumiy piksellar: " + (height * width));
        System.out.println("--------------------------------------------");
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                int pixel = image.getRGB(i, j);
                String idata=(getARGBPixelData(pixel));
                System.out.print("Pixel ("+i+","+j+"): ");
                System.out.print(idata);
                if(pix_num<total_pix)       //To delete the line that generates at end of file
                {
                    System.out.println("");
                }
                pix_num++;
            }
        }
    }
 
    public static String getARGBPixelData(int pixel)
    {
        String ARGBvalue="";
        int alpha = (pixel >> 24) & 0x000000FF;
        int red = (pixel >> 16) & 0x000000FF;
        int green = (pixel >>8 ) & 0x000000FF;
        int blue = (pixel) & 0x000000FF;
        ARGBvalue = alpha + " " + red + " " + green + " " + blue;
        return ARGBvalue;
    }
 
    public static BufferedImage readImage(String fileLocation) throws IOException
    {
        BufferedImage img = null;
        img = ImageIO.read(new File(fileLocation));
        return img;
    }
}