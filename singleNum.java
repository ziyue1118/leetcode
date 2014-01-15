public class singleNum {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int target = 0;
        for(int i=0;i<A.length;i++){
            target = target ^ A[i];
        }
        return target;
    }
    public static void main(String[] args){
        singleNum sN = new singleNum();
        int[] data = {2,3,2,3,4,5,5,6,6,7,7};
        System.out.println(sN.singleNumber(data));
    }
}