package Domain.Useful;

import java.awt.event.KeyEvent;

public enum HotKeys {
    MOVE_RIGHT(KeyEvent.VK_KP_RIGHT),
    MOVE_LEFT(KeyEvent.VK_KP_LEFT),
    ROTATE_RIGHT(KeyEvent.VK_A),
    ROTATE_LEFT(KeyEvent.VK_D),
    SHOOT(KeyEvent.VK_KP_UP),
    PICK_ATOM(KeyEvent.VK_C),
    BLEND(KeyEvent.VK_B),
    ATOM_TYPE1(KeyEvent.VK_1),
    ATOM_TYPE2(KeyEvent.VK_2),
    ATOM_TYPE3(KeyEvent.VK_3),
    ATOM_TYPE4(KeyEvent.VK_4),
    PAUSE(KeyEvent.VK_P),
    RESUME(KeyEvent.VK_R),
    SAVE(KeyEvent.VK_S),
    LOAD(KeyEvent.VK_L);

    private int id;

    HotKeys(int id) {
        this.id = id;
    }
}
