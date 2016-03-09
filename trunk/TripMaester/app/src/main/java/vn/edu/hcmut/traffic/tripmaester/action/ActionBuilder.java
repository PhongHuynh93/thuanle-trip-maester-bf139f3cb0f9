package vn.edu.hcmut.traffic.tripmaester.action;


/**
 * Created by thuanle on 12/18/15.
 */
public class ActionBuilder {
    public static ActionTripComment.Builder requestCommentTrip() {
        return new ActionTripComment.Builder();
    }
}
