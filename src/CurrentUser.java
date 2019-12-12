public class CurrentUser {
    /**
     * @author calebcramer
     * essentially a global variable that holds the learner's details
     */
    private static Learner cu;

    public static Learner getCu() {
        return cu;
    }

    public static void setCu(Learner cu) {
        CurrentUser.cu = cu;
    }

    public static void changeLast(double last){
        cu.setLastScore(last);
    }

}
