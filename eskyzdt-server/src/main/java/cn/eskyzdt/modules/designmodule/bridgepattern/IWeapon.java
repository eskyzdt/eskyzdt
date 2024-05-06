package cn.eskyzdt.modules.designmodule.bridgepattern;

/**
 *
 *
 * @since 2024-05-06
 * @author dongtian.zhang
 */
public abstract class IWeapon {

    protected int attack;

    public int defend;

    public int getAttack() {
        return attack;
    }


    public int getDefend() {
        return defend;
    }

}
