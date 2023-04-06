package ca.georgiancollege.comp1011winter2023thursdayafternoon;

public class CalcModel {

    private String num1="", num2="", result="", operator="";
    private double num1Value, num2Value, resultValue;

    public CalcModel(){}

    public void buttonPressed(String text){

        result = "";
        if(text.equals("+") || text.equals("*") || text.equals("-") || text.equals("/")){
            operator = text;
        }
        else if(text.equals("=")){

            num1Value = Double.parseDouble(num1);
            num2Value = Double.parseDouble(num2);

            switch(operator){
                case "+": {
                    resultValue = num1Value + num2Value;
                    setResult(resultValue + "");

                }
                case "-": {
                    resultValue = num1Value - num2Value;
                    setResult(resultValue + "");

                }
                case "/": {
                    resultValue = num1Value / num2Value;
                    setResult(resultValue + "");


                }
                default: {
                    resultValue = num1Value * num2Value;
                    setResult(resultValue + "");


                }
            };
            
            num1 = "";
            num2 = "";
            operator = "";

        }
        else{
            if(operator.length() == 0){
                num1 += text;
                setResult(num1);
            }
            else{
                num2 += text;
                setResult(num2);
            }
        }

    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
