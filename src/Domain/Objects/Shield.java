package Domain.Objects;

import Domain.Utils.FinalValues;

public abstract class Shield implements Fireable{
    private Fireable contextObj;

    private int num_of_protons = 0;

    private int num_of_neutrons = 0;

    public Shield(Fireable contextObj){
        this.contextObj = contextObj;
        this.setNum_of_protons(contextObj.getNum_of_protons());
        this.setNum_of_neutrons(contextObj.getNum_of_neutrons());
    }

    @Override
    public int getNum_of_protons() {
        return num_of_protons;
    }

    public void setNum_of_protons(int num_of_protons) {
        this.num_of_protons = num_of_protons;
    }

    @Override
    public int getNum_of_neutrons() {
        return num_of_neutrons;
    }

    public void setNum_of_neutrons(int num_of_neutrons) {
        this.num_of_neutrons = num_of_neutrons;
    }
}
