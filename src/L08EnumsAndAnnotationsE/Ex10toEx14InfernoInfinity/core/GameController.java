package L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.core;

import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.annotatios.VersionControl;
import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.contracts.Controller;
import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.contracts.OutputWriter;
import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.contracts.Repository;
import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.entities.Weapon;
import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.enums.Command;
import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.enums.Gem;
import L08EnumsAndAnnotationsE.Ex10toEx14InfernoInfinity.factories.WeaponFactory;

public class GameController implements Controller {
    private OutputWriter writer;
    private Repository<Weapon> weapons;

    public GameController(OutputWriter writer, Repository<Weapon> weapons) {
        this.writer = writer;
        this.weapons = weapons;
    }

    @Override
    public void dispatchCommand(String[] tokens) {
        Command command = Enum.valueOf(Command.class, tokens[0].toUpperCase());
        Weapon weapon;
        String name;
        int index;
        Class<Weapon> weaponClass;

        switch (command) {
            case CREATE:
                weapon = WeaponFactory.create(tokens);
                this.weapons.add(weapon);
                break;
            case ADD:
                name = tokens[1];
                weapon = this.weapons.get(name);
                index = Integer.parseInt(tokens[2]);
                Gem gem = Enum.valueOf(Gem.class, tokens[3].toUpperCase());
                weapon.insertGem(index, gem);
                break;
            case REMOVE:
                name = tokens[1];
                index = Integer.parseInt(tokens[2]);
                weapon = this.weapons.get(name);
                weapon.removeGem(index);
                break;
            case COMPARE:
                Weapon firstWeapon = weapons.get(tokens[1]);
                Weapon secondWeapon = weapons.get(tokens[2]);
                if (firstWeapon.compareTo(secondWeapon) < 0) {
                    this.writer.write(String.format("%s (Item Level: %.1f)", secondWeapon.toString(), secondWeapon.getItemLevel()));
                } else {
                    this.writer.write(String.format("%s (Item Level: %.1f)", firstWeapon.toString(), firstWeapon.getItemLevel()));
                }
                break;
            case PRINT:
                name = tokens[1];
                this.writer.write(this.weapons.get(name).toString());
                break;
            case AUTHOR:
                weaponClass = Weapon.class;
                if (weaponClass.isAnnotationPresent(VersionControl.class)) {
                    VersionControl annotation = weaponClass.getAnnotation(VersionControl.class);
                    this.writer.write(String.format("Author: %s", annotation.author()));
                }
                break;
            case REVISION:
                weaponClass = Weapon.class;
                if (weaponClass.isAnnotationPresent(VersionControl.class)) {
                    VersionControl annotation = weaponClass.getAnnotation(VersionControl.class);
                    this.writer.write(String.format("Revision: %d", annotation.revision()));
                }
                break;
            case DESCRIPTION:
                weaponClass = Weapon.class;
                if (weaponClass.isAnnotationPresent(VersionControl.class)) {
                    VersionControl annotation = weaponClass.getAnnotation(VersionControl.class);
                    this.writer.write(String.format("Class description: %s", annotation.description()));
                }
                break;
            case REVIEWERS:
                weaponClass = Weapon.class;
                if (weaponClass.isAnnotationPresent(VersionControl.class)) {
                    VersionControl annotation = weaponClass.getAnnotation(VersionControl.class);
                    this.writer.write(String.format("Reviewers: %s", String.join(", ", annotation.reviewers())));
                }
                break;
        }
    }
}
