package creator.mvc.model.setup.order;

import creator.mvc.model.setup.Actable;
import creator.mvc.model.setup.ability.Ability;
import creator.util.Pair;

import java.util.ArrayList;

public class OrderOperations extends ArrayList<Pair<Actable, Ability>>{

    public int indexOf(Actable actable, Ability ability){
        for(int i = 0; i < size(); i++){
            if(get(i).has(actable, ability)){
                return i;
            }
        }
        return -1;
    }
}
