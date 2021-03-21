package sample.mode;

public class ModeFactory {
    public Mode getMode(String str) {
        Mode mode = null;
        switch (str) {
            case "classBtn":
                mode = new classMode();
                System.out.println(mode);
                break;
            case "caseBtn":
                mode = new usecaseMode();
                System.out.println(mode);
                break;
            default:
                break;
        }
        return mode;
    }
}
