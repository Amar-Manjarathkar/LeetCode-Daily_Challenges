class Triplet implements Comparable <Triplet>{
    int elem;
    int row;
    int col;

    public Triplet(int elem,int row,int col){
        this.elem=elem;
        this.row=row;
        this.col=col;
    }
    public int compareTo(Triplet obj){
        return this.elem-obj.elem;
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> arr) {
        int k=arr.size();
       PriorityQueue <Triplet> pq = new PriorityQueue<>();

        int max=Integer.MIN_VALUE;
        int ans[]={0,Integer.MAX_VALUE};//range to return;
        int range=Integer.MAX_VALUE;

        //sabse pahle k lists ka pahla element min heap medalna hai updating the max variable
        for(int i=0;i<k;i++){
            int elem=arr.get(i).get(0);
            int row=i;
            int col=0;
            max=Math.max(max,elem);
            pq.add(new Triplet(elem,row,col));
        }

        //ab algorightm of updationg the range
        while(true){
            Triplet top=pq.remove();
            
            int elem=top.elem;
            int row=top.row;
            int col=top.col;

           
            int newrange=max-elem;
            if(newrange<range){
                ans[0]=elem;
                ans[1]=max;
                range=newrange;
            }
            if(col==arr.get(row).size()-1)break;
            pq.add(new Triplet(arr.get(row).get(col+1),row,col+1));
            max=Math.max(max,arr.get(row).get(col+1));
        }
        return ans;
    }
}
