package manager;

import object.*;

public class Convert {

    // Decimal -> Binary
    public static String DecimalToBinary(DecimalNumber dn) {
        int num = dn.getDec();
        if (num == 0) {
            return "0";
        }
        String bin = "";
        while (num > 0) {
            bin = (num % 2) + bin;
            num /= 2;
        }
        return bin;
    }

    // Decimal -> Hexa
    public static String DecimalToHexa(DecimalNumber dn) {
        int num = dn.getDec();
        if (num == 0) {
            return "0";
        }
        String hex = "";
        char[] hexChar = "0123456789ABCDEF".toCharArray();
        while (num > 0) {
            hex = hexChar[num % 16] + hex;
            num /= 16;
        }
        return hex;
    }

    // Binary -> decimal
    public static int BinaryToDecimal(BinaryNumber bn) {
        String bin = bn.getBina();
        int dec = 0;

        // duyet tung ky tu trong chuoi nhi phan
        for (int i = 0; i < bin.length(); i++) {
            char c = bin.charAt(bin.length() - 1 - i);
            // bien c luu ky tu hien tai
            if (c == '1') {
                dec += Math.pow(2, i);
            }
        }
        return dec;
    }

    // hexa -> decimal
    public static int HexaToDecimal(HexaNumber hn) {
        String hex = hn.getHex();
        int dec = 0;

        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(hex.length() - 1 - i);

            int val;
            if (c >= '0' && c <= '9') {
                val = c - '0';
            } else {
                val = c - 'A' + 10;
            }
            dec += val * Math.pow(16, i);
        }
        return dec;
    }

    // Binary -> hexa
    public static String BinaryToHexa(BinaryNumber bn) {
        String bin = bn.getBina();
        int dec = BinaryToDecimal(bn);
        return DecimalToHexa(new DecimalNumber(dec));
    }

    // Hexa -> binary
    public static String HexaToBinary(HexaNumber hn) {
        String hex = hn.getHex();
        int dec = HexaToDecimal(hn);
        return DecimalToBinary(new DecimalNumber(dec));
    }
}
