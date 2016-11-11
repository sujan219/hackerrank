package contest.mayworldcodesprint;

import java.util.Scanner;

public class RichieRich {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        int k = scanner.nextInt();
	        String[] noStr = (scanner.next()).split("");
	        int[] arr = new int[n];
	        for(int i=0; i<n; ++i){
	            arr[i] = Integer.parseInt(noStr[i]);
	        }
	        
	        int noOfChangeNeeded = 0;
	        for(int i=0;i<n/2;++i){
	            if(arr[i] != arr[n-i-1]){
	                ++noOfChangeNeeded;
	            }
	        }
	        
	        if(noOfChangeNeeded > k){
	            System.out.println(-1);
	        }else{
	            StringBuffer changedIndices = new StringBuffer("");
	            for(int i=0;i<n/2;++i){
	                if(arr[i] != arr[n-i-1]){
	                    arr[i] = arr[n-i-1] = Math.max(arr[i], arr[n-i-1]);
	                    --noOfChangeNeeded;
	                    --k;
	                    changedIndices.append(i+",");
	                }
	            }

	            String str = changedIndices.toString();
	            for(int i=0; i<n/2 && k>0; ++i){
	                if(arr[i] != 9){
	                    if(str.indexOf(i+",") == -1){
	                    	if(k<2){
	                    		break;
	                    	}
	                        k-=2;
	                    }else{
	                    	if(k<1){
	                    		break;
	                    	}
	                        --k;
	                    }
	                    arr[i] = arr[n-i-1] = 9;
	                }
	            }
	            
	            if(n%2 != 0 && k>0){
	                arr[(int)Math.ceil(n/2)] = 9;
	            }

	            for(int i:arr)
	            System.out.print(i);
	        }
	    }
}
