public class ExcelSheetColumnNumber {

    private int ALPHBET = 26;

    public int titleToNumber(String s) {
        int columnNumber = 0;
        if ("".equals(s)) {
            return columnNumber;
        }
        int place = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char letter = s.charAt(i);
            columnNumber += (int)(letter - 'A' + 1) * place;
            place *= ALPHBET;
        }
        return columnNumber;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
        System.out.println(escn.titleToNumber("AB"));
    }
}