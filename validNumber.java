public class Solution{
	public boolean isNumber(String s) {
    s = s.trim();//elimate white space at begining and tail 
    if (s.length() > 0 && s.charAt(s.length() - 1) == 'e')
        return false; //avoid "3e" which is false
    String[] t = s.split("e");
    if (t.length == 0 || t.length > 2)
        return false;
    boolean res = valid(t[0], false);
    if (t.length > 1)
        res = res && valid(t[1], true);
    return res;
}
private boolean valid(String s, boolean hasDot) {
    if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-')) //avoid "1+", "+", "+."
    s = s.substring(1);
    char[] arr = s.toCharArray();
    if (arr.length == 0 || s.equals("."))
        return false;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == '.') {
            if (hasDot)
                return false;
            hasDot = true;

        } else if (!('0' <= arr[i] && arr[i] <= '9')) 
        //这个判断条件很重要，不能写成arr[i]<='0' || arr[i]>='9'，因为这样子就会跟'.'的情况重复，造成判断结果有错误，所以写成这种非的形式
            return false;
    }
    return true;
}
}
//rewrite by myself
public class Solution{
    public boolean isNumber(String s){
        s = s.trim();
        if(s.length() >0&&s.charAt(s.length()-1) == 'e')
            return false;
        String[] t = s.split("e");
        if(t.length == 0|| t.length >2)
            return false;
        boolean res = valid(t[0], false);
        if(t.length >1)
            res = res && valid(t[1],true);
        return res;
    }
    private boolean valid(String s , boolean hasDot){
        if(s.length() >0 && (s.charAt(0) == '+'|| s.charAt(0) == '-'))
            s = s.substring(1);
        char[] arr = s.toCharArray();
        if(arr.length == 0|| s.equals("."))
            return false;
        for(int i = 0; i<arr.length;i++)
        {
            if(arr[i] == '.')
            {
                if(hasDot)
                    return false;
                hasDot = true;
            }
            else if(!(arr[i] >= '0' && arr[i] <= '9'))
                return false;
        }
        return true;
    }
    
}

//state machine
public class Solution {

    public enum States {
            EMPTY,
            INVALID,
            VALID,
            EXPONENT
    }

    public class StateMachine {
        private State state;
        public StateMachine() {
            this.state = new EmptyState(true, true);
        }

        private abstract class State {
            public States state;
            public abstract State process(char c);
            public States getState() {
                return this.state;
            }
        }

        private class InvalidState extends State {
            public InvalidState () {
                super.state = States.INVALID;
            }
            public State process(char c) {
                return this;
            }
        }

        private class ExponentState extends State {
            public ExponentState() {
                super.state = States.EXPONENT;
            }

            public State process(char c) {
                if(Character.isDigit(c)) {
                    return new ValidState(false, false);
                }

                // still in the exponent phase, not quite valid, e.g. e-5 or e+9
                if(c == '-' || c == '+') {
                    return this;
                }

                return new InvalidState();
            }
        }

        private class ValidState extends State {
            private boolean allowPeriod, allowExponent;
            public ValidState(boolean allowPeriod, boolean allowExponent) {
                super.state = States.VALID;
                this.allowPeriod = allowPeriod;
                this.allowExponent = allowExponent;
            }
            public State process(char c) {
                if(Character.isDigit(c)) {
                    return this;
                }

                if((c == 'e' || c == 'E') && this.allowExponent) {
                    return new ExponentState();
                }

                if(c == '.' && allowPeriod) {
                    return new ValidState(false, this.allowExponent);
                }

                return new InvalidState();
            }
        }

        private class EmptyState extends State {
            private boolean allowPeriod, allowSign;
            public EmptyState(boolean allowPeriod, boolean allowSign) {
                super.state = States.EMPTY;
                this.allowPeriod = allowPeriod;
                this.allowSign = allowSign;
            }

            public State process(char c) {
                // We haven't seen a period or negative yet and still haven't seen a digit.
                if(c == ' ' && allowPeriod && allowSign) {
                    return this;
                }

                if(Character.isDigit(c)) {
                    return new ValidState(this.allowPeriod, true);
                }

                if(c == '.' && allowPeriod) {
                    return new EmptyState(false, false);
                }

                // If we get the first sign, continue. If we've seen a period this isn't valid.
                if((c == '-' || c == '+' ) && allowSign && allowPeriod) {
                    return new EmptyState(true, false);
                }

                return new InvalidState();
            }
        }

        public void process(char c) {
            States current = state.getState();
            state = state.process(c);
        }

        public States getState() {
            return this.state.getState();
        }
    }


    public boolean isNumber(String s) {
        StateMachine fsm = new StateMachine();
        String trimmedS = s.trim();
        int index = 0;
        while(fsm.getState() != States.INVALID && index < trimmedS.length()) {
            fsm.process(trimmedS.charAt(index));
            index++;
        }

        return fsm.getState() == States.VALID;
    }
}


public class Solution {
    public boolean isNumber(String s) {
    if(s==null)
        return false;
    s = s.trim();
    if(s.length()==0)
        return false;
    boolean dotFlag = false;
    boolean eFlag = false;
    for(int i=0;i<s.length();i++)
    {
        switch(s.charAt(i))
        {
            case '.':
                if(dotFlag || eFlag 
                || ((i==0||!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9')) 
                    && (i==s.length()-1||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'))))
                    return false;
                dotFlag = true;
                break;
            case '+':
            case '-':
                if((i>0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E'))
                  || (i==s.length()-1 || !(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'||s.charAt(i+1)=='.')))
                    return false;
                break;
            case 'e':
            case 'E':
                if(eFlag || i==s.length()-1 || i==0)
                    return false;
                eFlag = true;
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                break;
            default:
                return false;
        }
    }
    return true;
}
}
