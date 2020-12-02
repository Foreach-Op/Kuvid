package Domain.Objects;

import Domain.Useful.Subtype;

public class Atom extends GameObject implements Fireable {
    public Atom(Subtype type) {
        super();
    }

    @Override
    public void collision(GameObject collider) {

    }

}
