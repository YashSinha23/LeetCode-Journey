class MedianFinder {
    PriorityQueue<Integer> leftheap;
    PriorityQueue<Integer> rightheap;
    public MedianFinder() {
        leftheap = new PriorityQueue<>(Collections.reverseOrder());
        rightheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        leftheap.add(num);

        rightheap.add(leftheap.poll());

        if(rightheap.size() > leftheap.size()){
            leftheap.add(rightheap.poll());
        }
    }
    
    public double findMedian() {
        if(leftheap.size() > rightheap.size()){
            double res = leftheap.peek();
            return res;
        }else{
            double val1 = leftheap.peek();
            double val2 = rightheap.peek();
            return (val1+val2)/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */