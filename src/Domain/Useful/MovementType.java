package Domain.Useful;

import Domain.Modes.RunningMode;
import Domain.Objects.AlteredMovementofObject;
import Domain.Objects.MovementofObject;

import static Domain.Modes.RunningMode.L;

public enum MovementType {
    SPINNING(new MovementofObject(0 , (int) L, 10)),
    STATIONARY(new MovementofObject(0, (int) L)),
    ZIGZAG_LEFT(new MovementofObject(-(int) L, (int) L)),
    ZIGZAG_RIGHT(new MovementofObject((int) L, (int) L)),
    ZIGZAG (new AlteredMovementofObject((int) L, ZIGZAG_LEFT, ZIGZAG_RIGHT)),
    HALF_STATIONARY_THEN_ZIGZAG(new AlteredMovementofObject(RunningMode.screenHeight/2, STATIONARY, ZIGZAG, true)),
    QUARTER_STATIONARY_THEN_ZIGZAG(new AlteredMovementofObject(RunningMode.screenHeight/4, STATIONARY, ZIGZAG, true)),
    SHOOTER_MOVEMENT_RIGHT(new MovementofObject((int) L, 0, 0)),
    SHOOTER_MOVEMENT_LEFT(new MovementofObject((int) -L, 0, 0)),
    SHOOTER_ROTATE_RIGHT(new MovementofObject((int) 0, 0, -10)),
    SHOOTER_ROTATE_LEFT(new MovementofObject((int) 0, 0, -10));

    MovementofObject movement;
    MovementType(MovementofObject movement){
        this.movement=movement;
    }

    public MovementofObject getMovement() {
        return movement;
    }
}
