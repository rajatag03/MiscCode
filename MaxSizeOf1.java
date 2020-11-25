// "static void main" must be defined in a public class.

//Example 1
// Input 
// 10 --> Number
// 1 0 0 1 1 1 0 1 1 1
// Output is 4

//Example 2
// Input 
// 10 --> Number
// 1 0 0 1 1 1 0 0 1 1
// Output is 5


// Time Complexity O(N)
// Space Complexity O(N)

public class MaxSizeOf1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        System.out.println(max1s(arr,n));
    }
    
    static int max1s(int[] arr,int n){
        if(n==0) return 0;
        
        List<int[]> range=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                int s=i;
                while(i<n && arr[i]==1){
                    i++;
                }
                i--;
                range.add(new int[]{s,i});
            }
        }
        
        int len = range.get(0)[1]-range.get(0)[0]+1;
        int max=len;
        for(int[] r:range)
        System.out.println(r[0]+" "+r[1]);
        for(int i=1;i<range.size();i++){
            int[] prev=range.get(i-1);
            int[] curr=range.get(i);
            
            int prevlen = prev[1]-prev[0]+1;
            int currlen = curr[1]-curr[0]+1;
            
            max=Math.max(max,currlen);
            if(curr[0]-prev[1]==3){
                max=Math.max(max,prevlen+currlen);
            }
        }
        return max;
    }
}
