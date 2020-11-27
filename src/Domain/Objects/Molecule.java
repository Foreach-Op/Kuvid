package Domain.Objects;

public class Molecule extends GameObject implements Fallable {
    public Molecule(String type) {
        super();
        //..
    }


    public void collision(GameObject obj){
        if(obj.type=="Atom"){
            if(this.equals(obj)){
                this.getDestroy();
                obj.getDestroy();
            } else{
                obj.getDestroy();
            }
        } else if(obj.type=="Blocker"){
            this.getDestroy();
        }
    }

    @Override
    public boolean equals(Object obj) {
        GameObject gameObj=(GameObject) obj;
        return this.subType.equals(gameObj.subType);
    }


}
