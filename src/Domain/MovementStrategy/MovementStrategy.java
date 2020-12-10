package Domain.MovementStrategy;

import Domain.Objects.GameObject;

public interface MovementStrategy {

    void doMovement(GameObject obj);
    // Objeler oluşturulurken pozisyon limite dikkat et.
    int PositionLimit=50;
}
