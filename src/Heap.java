public class Heap<T,K extends Comparable<K>>{

    Elemento<T,K>[] A;

    private int heapSize;

    public Heap(int n) {

        A = new Elemento[n];
    }

    private void buildMaxHeap(){
        heapSize = A.length;

        for(int i = A.length/2;i>2;i--){
            maxHeapify(i);
        }
    }

    public void maxHeapify( int i){
        int l = left(i);

        int r = right(i);

        int largest;
        if(l<=heapSize && A[l].getKey().compareTo(A[i].getKey()) > 0){
            largest = l;
        }else {
            largest = i;
        }

        if(r<=heapSize && A[r].getKey().compareTo(A[largest].getKey()) > 0){
            largest = r;
        }

        if (largest != i){
            A[i] = A[largest];
            maxHeapify(largest);
        }

    }

    private int left(int i){
        return 2*i;
    }

    private int right(int i){
        return 2*i+1;
    }
}
