package datastructure.queue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReverseQueueTest {

    // Stack을 사용하여 queue를 stack처럼 만들기

    @Test
    public void test() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        reverseQueue(q);

        assertThat(q.poll(),is(3));
        assertThat(q.poll(),is(2));
        assertThat(q.poll(),is(1));
    }
    public Queue<Integer> reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }
        while(!stack.isEmpty()) {
            q.offer(stack.pop());
        }
        return q;
    }
}