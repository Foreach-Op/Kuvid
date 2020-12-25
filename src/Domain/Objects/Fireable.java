package Domain.Objects;

import Domain.Utils.Position;

public interface Fireable {
    double getEfficiency();
    int getNum_of_protons();
    int getNum_of_neutrons();
    Position getVelocity();
}
