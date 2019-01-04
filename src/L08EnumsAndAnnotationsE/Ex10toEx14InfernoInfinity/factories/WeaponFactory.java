package L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.factories;

import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.entities.Weapon;
import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.enums.WeaponType;

public class WeaponFactory {
    private WeaponFactory() {

    }

    public static Weapon create(String[] tokens) {
        WeaponType weaponType = Enum.valueOf(WeaponType.class, tokens[1].toUpperCase());
        String name = tokens[2];
        return new Weapon(name, weaponType);
    }
}
