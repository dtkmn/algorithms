package leetcode;


/**
 * https://leetcode.com/problems/defanging-an-ip-address/
 */
public class DefangingAnIpAddress {

    public static String defangIPaddr(String address) {
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                output.append("[.]");
            } else output.append(address.charAt(i));
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println("Result: " + defangIPaddr("192.168.2.1"));
    }

}
