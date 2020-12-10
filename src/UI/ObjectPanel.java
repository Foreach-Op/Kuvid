package UI;

import Domain.Useful.Position;
import Domain.Useful.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObjectPanel extends JPanel{

    private BufferedImage image;
    private Image newImage;
    private int positionX;
    private int positionY;
    private JLabel imageLabel;
    //
    public ObjectPanel(String type, String subtype, Position position) {

        imageLabel=new JLabel();
        positionX=(int) position.getX();
        positionY=(int) position.getY();

        //this.setBounds(positionX,positionY,100,100);
        try {
            System.out.println("/assets/"+type+"s/"+subtype);
            image = ImageIO.read(new File("assets/"+type+"s/"+subtype+".png"));
            newImage = image.getScaledInstance(100, 200, Image.SCALE_DEFAULT);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //Icon imageIcon=new ImageIcon(newImage);
        //imageLabel.setIcon(imageIcon);
        //imageLabel.setLocation(positionX,positionY);
        //this.add(imageLabel);
        //this.setBounds(positionX,positionY,100,100);
    }

    public void updatePosition(Position newPosition){
        positionX=(int) newPosition.getX();
        positionY=(int) newPosition.getY();
        repaint();
        //System.out.println(positionX+" "+positionY);
        //aaa
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //this.setBackground(Color.CYAN);
        g.drawImage(newImage, positionX, positionY, this);
    }
}
