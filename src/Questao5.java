public class Questao5 {
    public static String inverterStrings (String normal){
        String invertida = "";
        for (int i = normal.length() - 1; i >= 0; i--) {
            invertida += normal.charAt(i);
        }
        return invertida;
    }
}
