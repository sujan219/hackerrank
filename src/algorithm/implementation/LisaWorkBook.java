package algorithm.implementation;

import java.util.Scanner;

public class LisaWorkBook {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int pageNumber = 0;
        int specialCount = 0;
        for(int i=0; i<n; ++i){
            int tI = scanner.nextInt();
            int questions = 0;
            do{
                ++pageNumber;
                
                if(pageNumber > questions && pageNumber<=Math.min(questions+k, questions+tI)){
                    ++specialCount;
                }
                
                tI = tI-k;
                questions += k;
            }while(tI > 0);
        }
        System.out.println(specialCount);
    }
}
