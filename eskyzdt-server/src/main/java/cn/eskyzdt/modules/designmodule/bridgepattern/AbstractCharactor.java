package cn.eskyzdt.modules.designmodule.bridgepattern;

/**
 *
 *
 * @since 2024-05-06
 * @author dongtian.zhang
 */
public abstract class AbstractCharactor {

    protected IWeapon weapon;

    public AbstractCharactor(IWeapon weapon) {
        this.weapon = weapon;
    }

    protected abstract void attackSth();

}
