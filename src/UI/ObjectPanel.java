package UI;

import Domain.Useful.Position;
import Domain.Useful.Rectangle;
import javafx.geometry.Pos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObjectPanel extends JPanel{

    private BufferedImage image;
    private int positionX;
    private int positionY;
    //
    public ObjectPanel(String type, String subtype, Position position) {
        positionX=(int) position.getX();
        positionY=(int) position.getY();
        
        this.setBounds(positionX,positionY,100,100);
        try {
            System.out.println("/assets/"+type+"s/"+subtype);
            image = ImageIO.read(new File("assets/"+type+"s/"+subtype+".png"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void updatePosition(Position newPosition){
        positionX=(int) newPosition.getX();
        positionY=(int) newPosition.getY();
        //System.out.println(positionX+" "+positionY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, positionX, positionY, this);
    }
}
