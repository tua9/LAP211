
package com.mycompany.week05;

public class BigNum {
    private String num = "";
    
    public BigNum(String num) {
        this.num = num;
    }
    
    public BigNum add(BigNum addNum) {
        String num1 = getNum();
        String num2 = addNum.getNum();
        
        num1 = fillLeadingZeros(num1, num2);
        num2 = fillLeadingZeros(num2, num1);
       
        String result = addTwoNumString(num1, num2);

        return new BigNum(result);
    }
    
    public String addTwoNumString(String a, String b) {
        String result = "";
        int i = Math.max(a.length(), b.length()) - 1;
        int remainder = 0;

        while(i > -1) {
            int num_1 = a.charAt(i) - '0';
            int num_2 = b.charAt(i) - '0';
            int sum = remainder + num_1 + num_2;
            remainder = sum / 10;
            result = (char)((sum % 10) + '0') + result;
            i--;
        }
        
        if(remainder > 0) result = (char)(remainder + '0') + result;
        result = result.replaceFirst("^0+(?!$)", "");
        
        return result;
    }
    
    public BigNum multiply(BigNum multiplyNum) {
        String num1 = getNum();
        String num2 = multiplyNum.getNum();
        
        if (num1.equals("0") || num2.equals("0")) return new BigNum("0");
        
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int multiply = digit1 * digit2;

                int sum = multiply + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (sb.length() == 0 && num == 0) continue; 
            sb.append(num);
        }

        return new BigNum(sb.toString());
    }
    
    public String fillLeadingZeros(String a, String b) {
        while(a.length() < b.length()) a = '0' + a;
        return a;
    }
    
    public String getNum() {
        return num;
    }
    
    @Override
    public String toString() {
        return num;
    }
}