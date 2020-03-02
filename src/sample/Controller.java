package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import javax.swing.text.html.ImageView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Controller {
    Date d = new Date();
    Calendar calendar = new GregorianCalendar();
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    String pattern = "";

    @FXML
    private TextArea patternField;

    @FXML
    private ImageView github;

    @FXML
    private TextArea resultField;

    @FXML
    private TextArea errorsField;

    @FXML
    private Button determineButton;

    @FXML
    void initialize() {
        determineButton.setOnAction(actionEvent -> {
            try {
                pattern = patternField.getText();
                d = format.parse(pattern);
                calendar.setTime(d);
                resultField.setText(new SimpleDateFormat("EEEE").format(d));
            } catch (ParseException pe) {
                errorsField.setText(pe.toString());
            }
        });

    }
}
