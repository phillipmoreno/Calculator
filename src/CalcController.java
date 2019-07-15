import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

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
			display.setText(removeZero(display.getText() + "1"));
		} else if (event.getSource() == two) {
			display.setText(removeZero(display.getText() + "2"));
		} else if (event.getSource() == three) {
			display.setText(removeZero(display.getText() + "3"));
		} else if (event.getSource() == four) {
			display.setText(removeZero(display.getText() + "4"));
		} else if (event.getSource() == five) {
			display.setText(removeZero(display.getText() + "5"));
		} else if (event.getSource() == six) {
			display.setText(removeZero(display.getText() + "6"));
		} else if (event.getSource() == seven) {
			display.setText(removeZero(display.getText() + "7"));
		} else if (event.getSource() == eight) {
			display.setText(removeZero(display.getText() + "8"));
		} else if (event.getSource() == nine) {
			display.setText(removeZero(display.getText() + "9"));
		} else if (event.getSource() == zero) {
			display.setText(removeZero(display.getText() + "0"));
		} else if (event.getSource() == clear) {
			display.setText("0");
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
			// switch statement used for variation of operators
			switch (operator) {
			case 1:
				double ans = add(data, secondOperand);
				// if statements are used to ensure that a decimal value is displayed when
				// necessary
				if (ans % 1.0 == 0.0) {
					display.setText(String.valueOf((int) ans));
				} else {
					display.setText(String.valueOf((double) Math.round(ans * 100000000000d) / 100000000000d));
				}
				break;

			case 2:
				ans = 0;
				ans = divide(data, secondOperand);
				if (ans % 1.0 == 0.0) {
					display.setText(String.valueOf((int) ans));
				} else {

					display.setText(String.valueOf((double) Math.round(ans * 100000000000d) / 100000000000d));
				}
				break;
			case 3:
				ans = 0;

				ans = multiply(data, secondOperand);
				if (ans % 1.0 == 0.0) {
					display.setText(String.valueOf((int) ans));
				} else {
					display.setText(String.valueOf((double) Math.round(ans * 100000000000d) / 100000000000d));
				}
				break;
			case 4:
				ans = 0;

				ans = subtract(data, secondOperand);

				if (ans % 1.0 == 0.0) {
					display.setText(String.valueOf((int) ans));
				} else {
					display.setText(String.valueOf((double) Math.round(ans * 100000000000d) / 100000000000d));
				}
				break;
			}
		}
	}

	KeyCombination shiftPlus = new KeyCodeCombination(KeyCode.EQUALS, KeyCodeCombination.SHIFT_DOWN);
	KeyCombination eightKey = new KeyCodeCombination(KeyCode.DIGIT8);
	KeyCombination shiftStar = new KeyCodeCombination(KeyCode.DIGIT8, KeyCodeCombination.SHIFT_DOWN);
	
	@FXML
	public void keyPressed(KeyEvent e) {
		if (e.getCode().equals(KeyCode.DIGIT1)) {
			display.setText(removeZero(display.getText() + "1"));
		} else if (e.getCode() == KeyCode.DIGIT2) {
			display.setText(removeZero(display.getText() + "2"));
		} else if (e.getCode() == KeyCode.DIGIT3) {
			display.setText(removeZero(display.getText() + "3"));
		} else if (e.getCode() == KeyCode.DIGIT4) {
			display.setText(removeZero(display.getText() + "4"));
		} else if (e.getCode() == KeyCode.DIGIT5) {
			display.setText(removeZero(display.getText() + "5"));
		} else if (e.getCode() == KeyCode.DIGIT6) {
			display.setText(removeZero(display.getText() + "6"));
		} else if (e.getCode() == KeyCode.DIGIT7) {
			display.setText(removeZero(display.getText() + "7"));
		} else if (eightKey.match(e)) {
			display.setText(removeZero(display.getText() + "8"));
		} else if (e.getCode() == KeyCode.DIGIT9) {
			display.setText(removeZero(display.getText() + "9"));
		} else if (e.getCode() == KeyCode.DIGIT0) {
			display.setText(removeZero(display.getText() + "0"));
		} else if (e.getCode() == KeyCode.PLUS || shiftPlus.match(e)) {
			plus.fire();
		} else if (e.getCode() == KeyCode.MINUS) {
			subtract.fire();
		} else if (e.getCode() == KeyCode.MULTIPLY || shiftStar.match(e)) {
			multiply.fire();
		} else if (e.getCode() == KeyCode.SLASH) {
			divide.fire();
		} else if (e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.EQUALS) {
			equals.fire();
		} else if (e.getCode() == KeyCode.BACK_SPACE) {
			display.setText(removeLastCharacter(display.getText()));
		}else if(e.getCode() == KeyCode.C) {
			clear.fire();
		}else if(e.getCode() == KeyCode.PERIOD) {
			display.setText(display.getText() + ".");
		}
	}

	public static String removeLastCharacter(String str) {
		String result = Optional.ofNullable(str).filter(sStr -> sStr.length() != 0)
				.map(sStr -> sStr.substring(0, sStr.length() - 1)).orElse(str);
		return result;
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

	private String removeZero(String aString) {
		String bString = aString;
		char firstChar = aString.charAt(0);
		if (firstChar == '0') {
			aString = aString.substring(1);
			return aString;
		} else
			return bString;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}