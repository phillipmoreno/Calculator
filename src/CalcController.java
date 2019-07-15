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
			display.setText("1");
		} else if (event.getSource() == two) {
			display.setText("2");
		} else if (event.getSource() == three) {
			display.setText("3");
		} else if (event.getSource() == four) {
			display.setText("4");
		} else if (event.getSource() == five) {
			display.setText("5");
		} else if (event.getSource() == six) {
			display.setText("6");
		} else if (event.getSource() == seven) {
			display.setText("7");
		} else if (event.getSource() == eight) {
			display.setText("8");
		} else if (event.getSource() == nine) {
			display.setText("9");
		} else if (event.getSource() == zero) {
			display.setText("0");
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
		} else if (event.getSource() == multiply) {
			data = Double.parseDouble(display.getText());
			operator = 3;
			display.setText("");
		} else if (event.getSource() == subtract) {
			data = Double.parseDouble(display.getText());
			operator = 4;
			display.setText("");
		} else if (event.getSource() == equals) {
			double secondOperand = Double.parseDouble(display.getText());
			// switch statement is used for variation of operators
			switch (operator) {
			case 1:
				double ans = add(data, secondOperand);
				// if/else statements are created to ensure that a double value is displayed
				// only when necessary
				if (ans % 1.0 == 0.0) {
					display.setText(String.valueOf((int) ans));
				} else {
					display.setText(String.valueOf(ans));
				}
				break;

			case 2:
				ans = 0;
				ans = divide(data, secondOperand);
				if (ans % 1.0 == 0.0) {
					display.setText(String.valueOf((int) ans));
				} else {
					display.setText(String.valueOf(ans));
				}
				break;
			case 3:
				ans = 0;

				ans = multiply(data, secondOperand);
				if (ans % 1.0 == 0.0) {
					display.setText(String.valueOf((int) ans));
				} else {
					display.setText(String.valueOf(ans));
				}
				break;
			case 4:
				ans = 0;

				ans = subtract(data, secondOperand);
				if (ans % 1.0 == 0.0) {
					display.setText(String.valueOf((int) ans));
				} else {
					display.setText(String.valueOf(ans));
				}
				break;
			}
		}
	}

	private static double add(double num1, double num2) {
		return num1 + num2;
	}

	private static double subtract(double num1, double num2) {
		return num1 - num2;
	}

	private static double divide(double num1, double num2) {
		return num1 / num2;
	}

	private static double multiply(double num1, double num2) {
		return num1 * num2;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}