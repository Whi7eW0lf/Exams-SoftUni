package callofduty.models.missions;

public class SurveillanceMission extends MissionImpl {

    public SurveillanceMission(String id, Double rating, Double bounty) {
        super(id, decreaseRating(rating), increaseBounty(bounty));
    }

    private static Double increaseBounty(Double bounty) {
        return bounty * 1.50;
    }

    private static Double decreaseRating(Double rating) {
        return rating * 0.25;
    }
}
