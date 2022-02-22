        import java.util.Arrays;
        import java.util.NoSuchElementException;
        import java.util.logging.Level;
        import java.util.logging.Logger;

public class MyQueue {
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private final static int DEFAULT_CAPACITY = 10;
    private float RISING_FACTOR = 1.5f;

    private Integer[] list;
    private int size;
    private int capacity;
    private int begin;
    private int end;



    public MyQueue(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
            logger.log(Level.WARNING, "Error creating a stack with size= " + capacity + ". The default value is used.");
        }
        this.capacity = capacity;
        list = new Integer[capacity];
    }

    public MyQueue() {
        this(DEFAULT_CAPACITY);
    }


    /** Push element x to the back of queue. */
    public void push(int x) {
        if (isFull()) {
            reCapacity();
        }
        size++;
        list[end] = x;
        end = nextIndex(end);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int temp = (int)peek();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    /** Get the front element. */
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }


    private boolean isFull() {
        return size == list.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int size() {
        return size;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private void reCapacity() {
        int temp = capacity + begin;
        end = capacity;
        capacity *= RISING_FACTOR;
        Integer[] newList = (Integer[]) new Object[capacity];

        for (int i = begin, j = 0; i < temp ; i++, j++) {
            newList[j] = list[nextIndex(i - 1)];
        }
        list = newList;
        begin = 0;
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        System.out.println(myQueue);
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue);
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue);
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue);
        myQueue.empty(); // return false
    }
}
