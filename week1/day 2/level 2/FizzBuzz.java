import java.util.Scanner;

class FizzBuzz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        
        if (num >= 1){
            for(int i = 1; i<= num; i++){
                if(i % 3 == 0 && i % 5 == 0){
                    System.out.println("FizzBuzz");
                } else if(i % 3 == 0){
                    System.out.println("Fizz");
                } else if(i % 5 == 0){
                    System.out.println("Buzz");
                } else{
                    System.out.println(i);
                }
            }
        }
    }
}