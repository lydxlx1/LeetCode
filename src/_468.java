/**
 * LeetCode 468 - Validate IP Address
 */
public class _468 {
    private boolean isV4(String IP) {
        if (!IP.matches("([0-9]{1,3}\\.){3}[0-9]{1,3}")) return false;
        for (String token : IP.split("\\."))
            if (token.charAt(0) == '0' && !token.equals("0")) return false;
            else {
                int val = Integer.parseInt(token);
                if (val < 0 || val > 255) return false;
            }
        return true;
    }

    private boolean isV6(String IP) {
        return IP.matches("([0-9a-f]{1,4}:){7}[0-9a-f]{1,4}");
    }

    public String validIPAddress(String IP) {
        IP = IP.toLowerCase();
        if (isV4(IP)) return "IPv4";
        else if (isV6(IP)) return "IPv6";
        else return "Neither";
    }
}