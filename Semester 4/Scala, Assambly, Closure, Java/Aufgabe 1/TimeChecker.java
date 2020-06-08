import java.util.regex.Pattern;

public class TimeChecker {

    public boolean timematcherschlau(String s){
        return Pattern.matches("(([0-1][0-9])|([2][0-3])):[0-5][0-9]", s);
    }

    public boolean timematcherdumm(String s) {
        if (s.length() == 5) {
            if (s.charAt(0) == '0' || s.charAt(0) == '1') {
                if (s.charAt(1) == '0' || s.charAt(1) == '1' || s.charAt(1) == '2' || s.charAt(1) == '3' || s.charAt(1) == '4' || s.charAt(1) == '5' || s.charAt(1) == '6' || s.charAt(1) == '7' || s.charAt(1) == '8' || s.charAt(1) == '9') {
                    if (s.charAt(2) == ':') {
                        if (s.charAt(3) == '0' || s.charAt(3) == '1' || s.charAt(3) == '2' || s.charAt(3) == '3' || s.charAt(3) == '4' || s.charAt(3) == '5') {
                            if (s.charAt(4) == '0' || s.charAt(4) == '1' || s.charAt(4) == '2' || s.charAt(4) == '3' || s.charAt(4) == '4' || s.charAt(4) == '5' || s.charAt(4) == '6' || s.charAt(4) == '7' || s.charAt(4) == '8' || s.charAt(4) == '9') {
                                return true;
                            }
                        }
                    }
                } else if (s.charAt(0) == 2) {
                    if (s.charAt(1) == '0' || s.charAt(1) == '1' || s.charAt(1) == '2' || s.charAt(1) == '3' || s.charAt(1) == '4') {
                        if (s.charAt(2) == ':') {
                            if (s.charAt(3) == '0' || s.charAt(3) == '1' || s.charAt(3) == '2' || s.charAt(3) == '3' || s.charAt(3) == '4' || s.charAt(3) == '5') {
                                if (s.charAt(4) == '0' || s.charAt(4) == '1' || s.charAt(4) == '2' || s.charAt(4) == '3' || s.charAt(4) == '4' || s.charAt(4) == '5' || s.charAt(4) == '6' || s.charAt(4) == '7' || s.charAt(4) == '8' || s.charAt(4) == '9') {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }   else if (s.length() == 4) {
            if (s.charAt(0) == '0' || s.charAt(0) == '1' || s.charAt(0) == '2' || s.charAt(0) == '3' || s.charAt(0) == '4' || s.charAt(0) == '5' || s.charAt(0) == '6' || s.charAt(0) == '7' || s.charAt(0) == '8' || s.charAt(0) == '9') {
                if (s.charAt(1) == ':') {
                    if (s.charAt(2) == '0' || s.charAt(2) == '1' || s.charAt(2) == '2' || s.charAt(2) == '3' || s.charAt(2) == '4' || s.charAt(2) == '5') {
                        if (s.charAt(3) == '0' || s.charAt(3) == '1' || s.charAt(3) == '2' || s.charAt(3) == '3' || s.charAt(3) == '4' || s.charAt(3) == '5' || s.charAt(3) == '6' || s.charAt(3) == '7' || s.charAt(3) == '8' || s.charAt(3) == '9') {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
