package cn.eskyzdt.modules.designmodule.bridgepattern;

public class MainCharactor extends AbstractCharactor {

    public MainCharactor(IWeapon weapon) {
        super(weapon);
    }

    @Override
    protected void attackSth() {
        int attack = weapon.getAttack();
        System.out.println(attack);
    }

}
