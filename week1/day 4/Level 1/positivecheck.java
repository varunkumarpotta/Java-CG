import java.util.*;

public class Main{

    public int checkPNZ(int num){
        if(num>0){
            return 1;
        }
        else if(num<0){
            return -1;
        }
        else{
            return 0;
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        Main obj = new Main();


        System.out.println(obj.checkPNZ(num));
    }

}