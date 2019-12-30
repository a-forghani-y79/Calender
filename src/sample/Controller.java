package sample;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Label lblStatus;
    public TextArea txtEvent;
    String week_days[] = {"شنبه", "یکشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنج شنبه", "جمعه"};
    String[][] data = new String[13][32];
    Label[] lbls;
    public Label l11;
    public Label l12;
    public Label l13;
    public Label l14;
    public Label l15;
    public Label l16;
    public Label l17;
    public Label l21;
    public Label l22;
    public Label l23;
    public Label l24;
    public Label l25;
    public Label l26;
    public Label l27;
    public Label l31;
    public Label l32;
    public Label l33;
    public Label l34;
    public Label l35;
    public Label l36;
    public Label l37;
    public Label l41;
    public Label l42;
    public Label l43;
    public Label l44;
    public Label l45;
    public Label l46;
    public Label l47;
    public Label l51;
    public Label l52;
    public Label l53;
    public Label l54;
    public Label l55;
    public Label l56;
    public Label l57;
    public Label l61;
    public Label l62;
    public Label l63;
    public Label l64;
    public Label l65;
    public Label l66;
    public Label l67;

    public JFXComboBox comboBox;
    public JFXTextField txtYear;
    public JFXTextField txtMonth;
    Label Clicked ;

    String day;
    int month;
    int year;
    int StartDay;
    int monthLength;
    int selectedDay;


    public void onClick(MouseEvent event) {
        setAllDefultBackgroung(lbls);
        Label label = (Label) event.getSource();
        Clicked=label;
        label.setStyle("-fx-background-color : #2D2D2D");
        if (label.getText()!="")
        selectedDay = Integer.valueOf(label.getText());
        txtEvent.setText(data[month][selectedDay]);


    }
    public void onClickAddEvent(){
        Label label = Clicked;
        String text = txtEvent.getText();
        if (label.getText()!="")
            selectedDay = Integer.valueOf(label.getText());
        else
            selectedDay=0;
        data[month][selectedDay]=text;
    }

    public void test() {

        System.out.println("Clicked !");
    }

    public void onClickSet() {
        day = (String) comboBox.getValue();
        month = Integer.valueOf(txtMonth.getText());
        year = Integer.valueOf(txtYear.getText());
        StartDay = getIndexDay(week_days, day);
        monthLength = getMounthLengh(month, isKabisa(year));

        lblStatus.setText("ماه: "+ month+"     "+"سال: "+year);

        setupCalender(StartDay, lbls, monthLength);


    }

    public void onClickNext() {
        StartDay = getNextMonthStartDay(monthLength, StartDay);
        if (month == 12) {
            month = 1;
            year++;
        } else month++;
        monthLength = getMounthLengh(month, isKabisa(year));
        lblStatus.setText("ماه: "+ month+"     "+"سال: "+year);
        setupCalender(StartDay, lbls, monthLength);

    }

    public void onClickPerivius() {
        StartDay = getPeriviusStartDay(monthLength, StartDay);
        if (month == 1) {
            month = 12;
            year--;
        } else month--;


        monthLength = getMounthLengh(month, isKabisa(year));
        lblStatus.setText("ماه: "+ month+"     "+"سال: "+year);
        setupCalender(StartDay, lbls, monthLength);


    }

    void setupCalender(int startDay, Label[] lbls, int monthLength) {
        int counter = 1;
        int lastDayMonth = 0;
        for (int i = 0; i < lbls.length; i++) {

            if (counter > monthLength || i < startDay) {
                lbls[i].setText("");
            } else {
                lbls[i].setText(counter + "");
                lastDayMonth = counter;
                counter++;
            }
        }
       // return (lastDayMonth + startDay - 1) % 7;


    }

    void setAllDefultBackgroung(Label[] labels) {

        for (int i = 0; i < labels.length; i++) {
            if (labels[i].getId().charAt(2) == '7')
                labels[i].setStyle("-fx-background-color : red");
            else
                labels[i].setStyle("-fx-background-color : #FFFFFF");
        }
    }

    int getIndexDay(String[] str, String string) {
        int index = -1;
        for (int i = 0; i < str.length; i++)
            if (str[i].equals(string)) {
                index = i;
                break;
            }

        return index;
    }


    boolean isKabisa(int sal) {
        int[] kabise = new int[]{4, 37, 66, 99, 132, 165, 198, 231, 264, 297, 326
                , 359, 392, 425, 458, 491, 524, 553, 586, 619, 656, 685, 718, 751, 784, 817
                , 850, 883, 916, 949, 978, 1011, 1044, 1077, 1110, 1143, 1176, 1209, 1238
                , 1275, 1308, 1343, 1370, 1401, 1436, 1473, 1502};
        int k = 0;
        for (int i = 0; i <= sal; i += 4) {
            if (i > kabise[k]) {
                i++;
                k++;
            }
            if (sal == i) {
                return true;
            }
        }
        return false;
    }

    int getMounthLengh(int month, boolean isKabisa) {
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

    int getNextMonthStartDay(int monthLength, int startDayMonth) {
        return (monthLength + startDayMonth) % 7;
    }

    int getPeriviusStartDay(int monthLength, int startDay) {

        if (monthLength==31)
        return (startDay - monthLength + 70 ) % 7;
        else
            return (startDay - monthLength + 70 ) % 7;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().addAll("شنبه", "یکشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنج شنبه", "جمعه");

        lbls = new Label[]{l11, l12, l13, l14, l15, l16, l17, l21, l22, l23, l24, l25, l26, l27, l31, l32, l33, l34, l35, l36, l37, l41, l42, l43, l44, l45, l46, l47,
                l51, l52, l53, l54, l55, l56, l57, l61, l62, l63, l64, l65, l66, l67};
        setAllDefultBackgroung(lbls);
        setupCalender(3, lbls, 31);
        data[1][13]="روز درخت کاری";
        data[1][1]="عید نوروز";
        data[11][22]="22 بهمن";
        data[11][12]="12 بهمن";




    }
}
