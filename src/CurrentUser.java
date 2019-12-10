public class CurrentUser {
    /**
     * @author calebcramer
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
