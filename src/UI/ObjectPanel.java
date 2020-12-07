package UI;

import Domain.Listeners.ObjectListener;
import Domain.Objects.GameObject;
import Domain.Objects.Position;

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
            image = ImageIO.read(new File("assets/"+type+"s/"+subtype));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //addOnGameScreen();
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
