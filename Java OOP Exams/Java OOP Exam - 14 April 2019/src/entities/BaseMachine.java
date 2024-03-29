package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMachine implements Machine {

    private static final String INVALID_MACHINE = "Machine name cannot be null or empty.";
    private static final String INVALID_PILOT = "Pilot cannot be null.";
    private static final String INVALID_TARGET = "Attack target cannot be null or empty string.";

    private String name;
    private Pilot pilot;
    private List<String> targets;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;

    protected BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {

        setName(name);
        setHealthPoints(healthPoints);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.targets = new ArrayList<>();

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        validatePilot(pilot);
        this.pilot = pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return this.targets;
    }

    @Override
    public void attack(String target) {
        validateTarget(target);
        this.targets.add(target);
    }

    @Override
    public String toString() {

        StringBuilder machineInfo = new StringBuilder();

        machineInfo
                .append(String.format("- %s%n", this.getName()))
                .append(String.format(" *Type: %s%n", this.getClass().getInterfaces()[0].getSimpleName()))
                .append(String.format(" *Health: %.2f%n", this.getHealthPoints()))
                .append(String.format(" *Attack: %.2f%n", this.getAttackPoints()))
                .append(String.format(" *Defense: %.2f%n", this.getDefensePoints()))
                .append(" *Targets: ");

        if (this.getTargets().isEmpty()) {
            machineInfo.append("None").append(System.lineSeparator());
        } else {
            machineInfo.append(this.getTargets().toString().replaceAll("[\\[\\]]","")).append(System.lineSeparator());
        }
        return machineInfo.toString();
    }

    protected void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    protected void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    private void validateTarget(String target) {
        if (target==null||target.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_TARGET);
        }
    }

    private void validateName(String name) {

        if (name==null||name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_MACHINE);
        }

    }

    private void validatePilot(Pilot pilot) {
        if (pilot==null){
            throw new NullPointerException(INVALID_PILOT);
        }
    }
}
