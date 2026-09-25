class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int calculation = 0;
        for (int i = 0; i < tokens.length; i++){
            if (tokens[i].equals("+") || tokens[i].equals("/") || tokens[i].equals("*") || tokens[i].equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                switch(tokens[i]){
                    case "+":
                        calculation = a + b;
                        break;
                    case "-":
                        calculation = b - a;
                        break;
                    case "*":
                        calculation = a * b;
                        break;
                    case "/":
                        calculation = b / a;
                        break;
                }
                stack.push(calculation);
            }
            else{
                int no = Integer.parseInt(tokens[i]);
                stack.push(no);
            }
        }
        return stack.pop();
    }
}
