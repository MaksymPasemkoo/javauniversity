package labfirst.taskfirst;

public class BinaryConvertor {
    public static void main(String[] args) {
        System.out.println(intoBinary(13));
    }
    private static String intoBinary(int number){
        String binaryNumber = "";
        if(number == 0) return "0";
        while(number > 0) {
            int tempNumber = number % 2;
            binaryNumber = tempNumber + binaryNumber;
            number /= 2;
        }

        return binaryNumber;
    }
}
