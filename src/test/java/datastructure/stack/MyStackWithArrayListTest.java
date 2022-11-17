package datastructure.stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyStackWithArrayListTest {

    @Test
    public void test() {
        MyStackWithArrayList<Integer> stack = new MyStackWithArrayList<>();

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
    * TASK
    * ArrayList 를 사용하여 Stack을 구현
    * */

    public class MyStackWithArrayList<T>{
        // 제네릭(Generic) - 데이터 형식에 의존하지 않고, 하나의 값이 여러 다른 데이터 타입들을 가질 수 있도록 함
        private List<T> data;

        public MyStackWithArrayList(){
            data = new ArrayList<T>();
        }

        public void push(T i){
            data.add(i);
        }

        public T pop(){
            return data.remove(data.size() -1);
        }
    }
}
