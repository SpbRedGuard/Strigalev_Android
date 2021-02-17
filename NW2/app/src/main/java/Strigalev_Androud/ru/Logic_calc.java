package Strigalev_Androud.ru;

public class Logic_calc {

        private int firstArg;
        private int secondArg;

        private StringBuilder inputStr = new StringBuilder();

        private int actionSelected;
        private State state;

        private enum State {
            firstArgInput,
            operationSelected,
            secondArgInput,
            resultShow
        }

        public Logic_calc() {
            state = State.firstArgInput;
        }

        public void onNumPressed(int buttonId) {

            if (state == State.resultShow) {
                state = State.firstArgInput;
                inputStr.setLength(0);
            }

            if (state == State.operationSelected) {
                state = State.secondArgInput;
                inputStr.setLength(0);
            }

            if (inputStr.length() < 10) {
                switch (buttonId) {
                    case R.id.button_0:
                        if (inputStr.length() != 0) {
                            inputStr.append("0");
                        }
                        break;
                    case R.id.button_double0:
                        if (inputStr.length() != 00) {
                            inputStr.append("00");
                        }
                        break;
                    case R.id.button_1:
                        inputStr.append("1");
                        break;
                    case R.id.button_2:
                        inputStr.append("2");
                        break;
                    case R.id.button_3:
                        inputStr.append("3");
                        break;
                    case R.id.button_4:
                        inputStr.append("4");
                        break;
                    case R.id.button_5:
                        inputStr.append("5");
                        break;
                    case R.id.button_6:
                        inputStr.append("6");
                        break;
                    case R.id.button_7:
                        inputStr.append("7");
                        break;
                    case R.id.button_8:
                        inputStr.append("8");
                        break;
                    case R.id.button_9:
                        inputStr.append("9");
                        break;
                }
            }

        }

        public void onActionPressed(int actionId) {
            if (actionId == R.id.button_equality && state == State.secondArgInput && inputStr.length() > 0) {
                secondArg = Integer.parseInt(inputStr.toString());
                state = State.resultShow;
                inputStr.setLength(0);
                switch (actionSelected) {
                    case R.id.addition:
                        inputStr.append(firstArg + secondArg);
                        break;
                    case R.id.subtraction:
                        inputStr.append(firstArg - secondArg);
                        break;
                    case R.id.multiplication:
                        inputStr.append(firstArg * secondArg);
                        break;
                    case R.id.division:
                        inputStr.append(firstArg / secondArg);
                        break;
                }

            } else if (inputStr.length() > 0 && state == State.firstArgInput) {
                firstArg = Integer.parseInt(inputStr.toString());
                state = State.operationSelected;
                actionSelected = actionId;
            }
        }

        public String getText() {
            StringBuilder str = new StringBuilder();
            switch (state) {
                default:
                    return inputStr.toString();
                case operationSelected:
                    return str.append(firstArg).append(' ')
                            .append(getOperationChar())
                            .toString();
                case secondArgInput:
                    return str.append(firstArg).append(' ')
                            .append(getOperationChar())
                            .append(' ')
                            .append(inputStr)
                            .toString();
                case resultShow:
                    return str.append(firstArg).append(' ')
                            .append(getOperationChar())
                            .append(' ')
                            .append(secondArg)
                            .append(" = ")
                            .append(inputStr.toString())
                            .toString();
            }
        }

        private char getOperationChar() {
            switch (actionSelected) {
                case R.id.addition:
                    return '+';
                case R.id.subtraction:
                    return '-';
                case R.id.multiplication:
                    return '*';
                case R.id.division:
                default:
                    return '/';

            }
        }

        public void reset() {
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

    public void correct() {
        state = State.firstArgInput;
        inputStr.setLength(0);
    }
}

