package datastructure.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyStackWithArrayTest {


    /*
        TASK
        Array 를 사용하여 Stack을 구현
    */

    @Test
    public void test() {
        MyStackWithArray stack = new MyStackWithArray();

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        assertThat(stack.pop(), is(6));
        assertThat(stack.pop(), is(5));
        assertThat(stack.pop(), is(4));
        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
        assertThat(stack.pop(), is(0));

    }

    /*
    * Stack
    * - 선형 자료구조의 일종
    * - 나중에 들어간 원소가 먼저 나온다. (LIFO)
    * - 먼저 들어간 원소가 나중에 나온다. (FILO)
    * - 차곡차곡 쌓이는 구조이다.
    * */

    public class MyStackWithArray {
        private int[] data = new int[5];
        private int topIndex = -1;

        public synchronized void push(int i) {
            /*
             * 멀티스레드 환경에서 스레드간 동기화
             * - 스레드간 서로 공유하고 수정할 수 있는 data가 있을 대 스레드간 동기화가 되지 않은 상태에서 멀티스레드 프로그램을 돌리면 data의 안정성과 신뢰성을 보장할 수 없다.
             * - 따라서, thread-safe를 하기 위해 Java에서느 sychronized 키워드를 제공해 스레드간 동기화를 시켜 data의 thread-safe를 가능하게 한다.
             * */
            topIndex++;
            if (topIndex >= data.length) {
                int[] oldData = data;
                data = new int[data.length * 2];
                for (int j = 0; j < oldData.length; j++) {
                    data[j] = oldData[j];
                }
            }
            data[topIndex] = i;
        }

        public synchronized int pop() {
            if (topIndex < 0) {
                throw new RuntimeException("Empty Stack!");
            }
            return data[topIndex--];
        }
    }
}
