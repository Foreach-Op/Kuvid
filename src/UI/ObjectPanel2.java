package UI;

import Domain.Useful.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObjectPanel2 {
    public Image newImage;
    public int positionX;
    public int positionY;
    //
    public ObjectPanel2(String type, String subtype, Position position) {
        positionX=(int) position.getX();
        positionY=(int) position.getY();

        //this.setBounds(positionX,positionY,100,100);
        try {
            //System.out.println("/assets/"+type+"s/"+subtype);
            BufferedImage image = ImageIO.read(new File("assets/" + type + "s/" + subtype + ".png"));
            newImage = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //this.setBounds(positionX,positionY,100,100);
    }

    public void updatePosition(Position newPosition){
        positionX=(int) newPosition.getX();
        positionY=(int) newPosition.getY();
        //System.out.println(positionX+" "+positionY);
    }
    public void draw(Graphics g){
        g.drawImage(newImage,positionX,positionY,null);
    }
}
