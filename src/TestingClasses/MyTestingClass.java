package TestingClasses;

public class MyTestingClass {
    private int value;

    public MyTestingClass(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {

        int p = 37;
        int res = 1;
        res = p * res + value;
        return res;
    }
}
