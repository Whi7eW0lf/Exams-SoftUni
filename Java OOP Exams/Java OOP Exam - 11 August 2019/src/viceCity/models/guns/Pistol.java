package viceCity.models.guns;

public class Pistol extends BaseGun {

    private static final int DEFAULT_BULLETS_PER_BARREL = 10;
    private static final int DEFAULT_TOTAL_BULLETS = 100;
    private static final int SHOOTING_BULLETS = 1;

    public Pistol(String name) {
        super(name, DEFAULT_BULLETS_PER_BARREL, DEFAULT_TOTAL_BULLETS);
    }

    @Override
    public int fire() {

        if (super.barrelIsEmpty()) {
            rechargeGun();
        }

        super.setBulletsPerBarrel(super.getBulletsPerBarrel()-SHOOTING_BULLETS);

        return SHOOTING_BULLETS;
    }

    @Override
    protected void rechargeGun() {
        super.setTotalBullets(super.getTotalBullets()-DEFAULT_BULLETS_PER_BARREL);
        super.setBulletsPerBarrel(DEFAULT_BULLETS_PER_BARREL);
    }
}
