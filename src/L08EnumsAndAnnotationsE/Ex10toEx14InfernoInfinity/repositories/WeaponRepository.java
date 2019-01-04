package L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.repositories;

import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.comparators.ItemLevelComparator;
import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.contracts.Repository;
import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.entities.Weapon;

import java.util.LinkedHashMap;
import java.util.Map;

public class WeaponRepository implements Repository<Weapon> {
    private Map<String, Weapon> weapons;

    public WeaponRepository() {
        this.weapons = new LinkedHashMap<>();
    }

    @Override
    public void add(Weapon element) {
        this.weapons.put(element.getName(), element);
    }

    @Override
    public Weapon get(String element) {
        return this.weapons.get(element);
    }

    @Override
    public boolean contains(String element) {
        return this.weapons.containsKey(element);
    }

    @Override
    public Iterable<Weapon> getElements() {
        return this.weapons.values();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public Weapon max() {
        return this.weapons
                .values()
                .stream()
                .max(new ItemLevelComparator())
                .get();
    }


}
