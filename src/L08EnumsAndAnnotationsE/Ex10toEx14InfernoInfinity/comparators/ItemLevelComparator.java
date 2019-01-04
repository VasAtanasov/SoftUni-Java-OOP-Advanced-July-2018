package L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.comparators;

import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.entities.Weapon;

import java.util.Comparator;

public class ItemLevelComparator implements Comparator<Weapon> {

    @Override
    public int compare(Weapon o1, Weapon o2) {
        return Double.compare(o1.getItemLevel(), o2.getItemLevel());
    }
}
