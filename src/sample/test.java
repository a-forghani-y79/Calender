package sample;

public class test {


    public static void main(String[] args) {
        int month = -1;
        month %= 12;
        System.out.println(month%12);
        month = (month == 0) ? 1 : month;
        System.out.println(month);
    }
    static int getMounthLengh(int month, boolean isKabisa) {
        int length = -1;
        if (month < 7)
            length = 31;
        else if (month != 12)
            length = 30;
        else {
            if (isKabisa)
                length = 30;
            else
                length = 29;
        }
        return length;
    }
}
