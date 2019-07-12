import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalcController implements Initializable {
	// data and operator variables are initialized
	double data = 0;
	int operator = -1;

	// Button objects are created
	@FXML
	private Button one;

	@FXML
	private Button two;

	@FXML
	private Button three;

	@FXML
	private Button four;

	@FXML
	private Button five;

	@FXML
	private Button six;

	@FXML
	private Button seven;

	@FXML
	private Button eight;

	@FXML
	private Button nine;

	@FXML
	private Button clear;

	@FXML
	private Button zero;

	@FXML
	private Button equals;

	@FXML
	private Button plus;

	@FXML
	private Button divide;

	@FXML
	private Button multiply;

	@FXML
	private Button subtract;

	// Textfield object is created
	@FXML
	private TextField display;

	@FXML
	void handleButtonAction(ActionEvent event) {
		if (event.getSource() == one) {
			display.setText(display.getText() + "1");
		} else if (event.getSource() == two) {
			display.setText(display.getText() + "2");
		} else if (event.getSource() == three) {
			display.setText(display.getText() + "3");
		} else if (event.getSource() == four) {
			display.setText(display.getText() + "4");
		} else if (event.getSource() == five) {
			display.setText(display.getText() + "5");
		} else if (event.getSource() == six) {
			display.setText(display.getText() + "6");
		} else if (event.getSource() == seven) {
			display.setText(display.getText() + "7");
		} else if (event.getSource() == eight) {
			display.setText(display.getText() + "8");
		} else if (event.getSource() == nine) {
			display.setText(display.getText() + "9");
		} else if (event.getSource() == zero) {
			display.setText(display.getText() + "0");
		} else if (event.getSource() == clear) {
			display.setText(" ");
		} else if (event.getSource() == plus) {
			data = Double.parseDouble(display.getText());
			operator = 1;
			display.setText("");
		} else if (event.getSource() == divide) {
			data = Double.parseDouble(display.getText());
			operator = 2;
			display.setText("");
		} else if (event.getSource() == equals) {
			double secondOperand = Double.parseDouble(display.getText());
			// switch statement is used for variation of operators
			switch (operator) {
			case 1:
				double ans = addition(data, secondOperand);
				// if/else statements are created to ensure that a double value is displayed
				// only when necessary
				if (ans % 1 == 0) {
					display.setText(String.valueOf((int) ans));
				} else {
					display.setText(String.valueOf(ans));
				}
				break;

			case 2:
				ans = 0;
				try {
					ans = division(data, secondOperand);
					if (ans % 1 == 0.00) {
						display.setText(String.valueOf((int) ans));
					} else {
						display.setText(String.valueOf(ans));
					}
				} catch (Exception e) {
					display.setText("Error");
				}
				break;
			}
		}
	}

	private static double addition(double num1, double num2) {
		return num1 + num2;
	}

	private static double subtraction(double num1, double num2) {
		return num1 + num2;
	}

	private static double division(double num1, double num2) {
		return num1 / num2;
	}

	private static double multiplication(double num1, double num2) {
		return num1 * num2;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}