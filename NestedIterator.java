import java.util.*;

public class NestedIterator implements Iterator<Integer> {

        List<NestedInteger> nestedList;
        Deque<NestedInteger> stack;
        Deque<Integer> queue;
        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
            stack = new LinkedList<>();
            queue = new LinkedList<>();
        }

        private void flattenList(){

            stack.addFirst(nestedList.get(0));
            while(!stack.isEmpty()){
                NestedInteger n = stack.pop();
                if(n.isInteger()){
                    int num = n.getInteger();
                    queue.add(num);
                }else {
                    if (n.getList() != null)
                        for(NestedInteger l : n.getList()){

                            stack.addFirst(l);
                        }
                }
            }

        }

        @Override
        public Integer next() {
            flattenList();
            if(hasNext()){
                return queue.poll();
            }
            return -1;
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

    public static void main(String [] args){
        List<NestedInteger> list = new ArrayList<>();
        //NestedInteger n1 = new

       // NestedIterator i = new NestedIterator(nestedList);
    }
}
