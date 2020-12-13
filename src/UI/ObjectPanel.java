package UI;

import Domain.Utils.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObjectPanel {
    public Image newImage;
    public int positionX;
    public int positionY;
    public int rotation;
    private int width;
    private int height;
    public String type;
    private BufferedImage bufferedImage;
    private String alphaBetaType;

    public ObjectPanel(String type, String subtype, Position position,int width,int height,String alphaBetaType) {
        this.width=width;
        this.height=height;
        positionX=(int) position.getX();
        positionY=(int) position.getY();
        rotation=position.getRotation();
        this.type=type;
        this.alphaBetaType=alphaBetaType;

        try {
            bufferedImage = ImageIO.read(new File("assets/" + type + "s/" + subtype + ".png"));
            if(type.equals("Molecule") && (subtype.equals("Alpha") || subtype.equals("Beta")) && alphaBetaType.equals("LINEAR")){
                bufferedImage = ImageIO.read(new File("assets/" + type + "s/" + subtype + "2" + ".png"));
            }
            BufferedImage rotatedImage=rotateImage();
            newImage = rotatedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private BufferedImage rotateImage() {
        final double rads = Math.toRadians(rotation);
        final double sin = Math.abs(Math.sin(rads));
        final double cos = Math.abs(Math.cos(rads));
        final int w = (int) Math.floor(bufferedImage.getWidth() * cos + bufferedImage.getHeight() * sin);
        final int h = (int) Math.floor(bufferedImage.getHeight() * cos + bufferedImage.getWidth() * sin);
        final BufferedImage rotatedImage = new BufferedImage(w, h, bufferedImage.getType());
        final AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads,0, 0);
        at.translate(-bufferedImage.getWidth() / 2, -bufferedImage.getHeight() / 2);
        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(bufferedImage,rotatedImage);
        return rotatedImage;
    }

    public void updatePosition(Position newPosition){
        positionX=(int) newPosition.getX();
        positionY=(int) newPosition.getY();
        rotation=newPosition.getRotation();
        if(type.equals("Shooter")){
            //System.out.println("Rotation: "+rotation);
            BufferedImage rotatedImage=rotateImage();
            newImage = rotatedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        }
    }

    public void draw(Graphics g){
        g.drawImage(newImage,positionX,positionY,null);
    }
}
