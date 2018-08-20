package L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.entities;

import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.annotatios.VersionControl;
import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.enums.Gem;
import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.enums.WeaponType;

import java.util.Arrays;
import java.util.Objects;

@VersionControl(
        author = "Pesho",
        revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"}
)
public class Weapon implements Comparable<Weapon> {
    private String name;
    private WeaponType weaponType;
    private Gem[] sockets;

    public Weapon(String name, WeaponType weaponType) {
        this.name = name;
        this.weaponType = weaponType;
        this.sockets = new Gem[weaponType.getSockets()];
    }

    public String getName() {
        return this.name;
    }

    public void insertGem(int index, Gem gem) {
        if (this.inRange(index)) {
            this.sockets[index] = gem;
        }
    }

    public void removeGem(int index) {
        if (this.inRange(index)) {
            this.sockets[index] = null;
        }
    }

    private int getStrength() {
        return Arrays.stream(this.sockets)
                .filter(Objects::nonNull)
                .mapToInt(Gem::getStrength)
                .reduce(0, Integer::sum);
    }

    private int getAgility() {
        return Arrays.stream(this.sockets)
                .filter(Objects::nonNull)
                .mapToInt(Gem::getAgility)
                .reduce(0, Integer::sum);
    }

    private int getVitality() {
        return Arrays.stream(this.sockets)
                .filter(Objects::nonNull)
                .mapToInt(Gem::getVitality)
                .reduce(0, Integer::sum);
    }

    private int getMinDamage() {
        int pointsFromStrength = this.getStrength() * 2;
        int pointsFromAgility = this.getAgility();
        return weaponType.getMinDamage() + pointsFromStrength + pointsFromAgility;
    }

    private int getMaxDamage() {
        int pointsFromStrength = this.getStrength() * 3;
        int pointsFromAgility = this.getAgility() * 4;
        return weaponType.getMaxDamage() + pointsFromStrength + pointsFromAgility;
    }

    public double getItemLevel() {
        return ((this.getMinDamage() + this.getMaxDamage()) / 2.0) + this.getStrength() + this.getAgility() + this.getVitality();
    }

    private boolean inRange(int index) {
        return index >= 0 && index < this.sockets.length;
    }

    @Override
    public int compareTo(Weapon other) {
        return Double.compare(this.getItemLevel(), other.getItemLevel());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name,
                this.getMinDamage(),
                this.getMaxDamage(),
                this.getStrength(),
                this.getAgility(),
                this.getVitality());
    }
}