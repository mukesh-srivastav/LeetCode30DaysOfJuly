public class Day19_AddBinary {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        String res = "";
        int i = m - 1, j = n-1, k = 0, c = 0;
        while (i >=0 && j >= 0) {
            k = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j)) + c;
            // System.out.print(k + " ");
            if (k >= 2) {
                c = 1;
                k = k % 2;
            } else {
                c = 0;
            }
            
            res = k + res;
            i--; j--;
        }
        // System.out.println();
        // System.out.print(i + " " + j);
        while (i >= 0) {
            k = Character.getNumericValue(a.charAt(i)) + c;
            
            if (k >= 2) {
                c = 1;
                k = k % 2;
            } else {
                c = 0;
            }
            res = k + res;
            i--;
        }
        
        while (j >= 0 ) {
            k = Character.getNumericValue(b.charAt(j)) + c;
            
            if (k >= 2) {
                c = 1;
                k = k % 2;
            } else {
                c = 0;
            }
            res = k + res;
            j--;
        }
        
        return (c == 1) ? c + res : res;
    }
}