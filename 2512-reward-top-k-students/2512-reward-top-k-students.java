class Pair{
    int id;
    int sum;
    public Pair(int id, int sum){
        this.id=id;
        this.sum=sum;
    }
}
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> pos = new HashSet<>();
        HashSet<String> neg = new HashSet<>();
        for(String x:positive_feedback ){
            pos.add(x);
        }
        for(String x:negative_feedback ){
            neg.add(x);
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->a.sum==b.sum? a.id-b.id: b.sum-a.sum);
        for(int i=0;i<report.length;i++){
            String x = report[i];
            String[] arr= x.split(" ");
            int s=0;
            for(int j=0;j<arr.length;j++){
                if(neg.contains(arr[j])){
                    s=s-1;
                }else if(pos.contains(arr[j])){
                    s+=3;
                }
            }
            maxHeap.add(new Pair(student_id[i],s));
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(maxHeap.poll().id);
        }
        return res;
    }
}