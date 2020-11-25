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

public class ObjectPanel extends JPanel implements ObjectListener {

    private BufferedImage image;
    private Position position;

    public ObjectPanel(String type,String subtype ,Position position) {
        this.position=position;
        this.setBounds(position.getX(),position.getY(),100,100);
        try {
            image = ImageIO.read(new File("src/Images/"+type+"/"+subtype));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public Position getPosition(){
        return this.position;
    }

    public void initialize(GameObject obj){
        obj.setPanel(this);
    }

    @Override
    public void addOnGameScreen() {
        GameScreen.getInstance().addObjectPanel(this);
    }

    @Override
    public void onLocationChange(Position position) {
        this.setBounds(position.getX(),position.getY(),100,100);
        //GameScreen.getInstance().addObjectPanel(this);
        repaint();
    }

    @Override
    public void onDestroy(){
        GameScreen.getInstance().remove(this);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
