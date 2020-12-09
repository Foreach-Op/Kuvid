package UI;

import Domain.Useful.Position;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObjectPanel extends JPanel{

    private BufferedImage image;
    private Position position;
    //
    public ObjectPanel(String type,String subtype ,Position position) {
        this.position=position;
        this.setBounds(position.getX(),position.getY(),100,100);
        try {
            System.out.println("/assets/"+type+"s/"+subtype);
            image = ImageIO.read(new File("assets/"+type+"s/"+subtype+".png"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void updatePosition(Position newPosition){
        this.position=newPosition;
        //repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
