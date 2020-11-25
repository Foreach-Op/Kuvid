package Domain.Objects;

public class Powerup extends GameObject implements Fallable,Fireable{
    public Powerup(String type) {
        super();
    }

    @Override
    public void collision(GameObject collider) {

    }
}
