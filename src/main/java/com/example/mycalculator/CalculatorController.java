package com.example.mycalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    Label textField;

    @FXML
    Label show;

    private char operation = '\0';
    private float firstNum;
    private float secondNum;

    @FXML
    public void clickOnButton(ActionEvent event){
        Button button = (Button) event.getSource();
        String text = textField.getText();
        if(button.getText().equals("c")){
            textField.setText("");
            show.setText("");
        }
        else if(button.getText().equals("b")){
            if (text.length() > 0)
                textField.setText(text.substring(0 , text.length()-1));
        }
        else if(button.getText().equals(".")){
            if(text.length() == 0){
                textField.setText("0.");
            }
            else {
                textField.setText(text + ".");
            }
        }
        else if(button.getText().equals("+") || button.getText().equals("-") || button.getText().equals("*")
                || button.getText().equals("/") || button.getText().equals("%")){
            if(text.length() > 0) {
                if(operation == '\0') {
                    operation = button.getText().charAt(0);
                    firstNum = Float.parseFloat(text);
                    textField.setText("");
                    show.setText(firstNum + " " + operation);
                }
                else {
                    firstNum = calculate(firstNum , Float.parseFloat(text) , operation);
                    operation = button.getText().charAt(0);
                    textField.setText("");
                    show.setText(firstNum + " " + operation);
                }
            }
        }
        else if(button.getText().equals("=")){
            if(text.length() > 0 && operation != '\0') {
                secondNum = Float.parseFloat(text);
                String out = "" + calculate(firstNum , secondNum , operation);
                textField.setText(out);
                show.setText(firstNum + " " + operation + " " + secondNum + " = " + out);
                operation = '\0';
            }
        }
        else {
            textField.setText(text + button.getText());
        }
    }

    public float calculate(float firstNum , float secondNum , char operation){
        switch (operation){
            case '*' :
                return firstNum * secondNum;
            case '/' :
                return firstNum / secondNum;
            case '-' :
                return firstNum - secondNum;
            case '+' :
                return firstNum + secondNum;
            case '%' :
                return firstNum % secondNum;
        }
        return 0;
    }
}