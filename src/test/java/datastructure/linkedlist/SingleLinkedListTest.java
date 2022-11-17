package datastructure.linkedlist;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SingleLinkedListTest {

    @Test
    public void test(){
        assertThat("", is(testFunction()));
    }

    public String testFunction(){
        return "";
    }

    /*
        Array
        - 논리적, 물리적 저장 순서가 일치하여, 찾고자 하는 원소의 인덱스 값을 알고 있으면 random access로 O(1)에 접근이 가능한 장점이 있다.
        - 하지만, 삭제 또는 삽입의 과정에서 O(1)의 작업 시 배열의 연속적인 특성이 깨지게 되어 해당 원소보다 큰 인덱스를 갖는 원소들을 shift 해줘야 하는 비용이 발생하여 최악의 경우 O(n)이 되는 단점이 있다.

        Linked List
        - Array 의 삭제 또는 삽입에서 최악의 경우 O(n)의 시간이 되는 문제를 해결하기 위한 자료구조이다.
        - 각각의 원소들이 자기 자신 다음에 어떤 원소인지만을 기억하고 있다.
        - Array와 달리 논리적 저장 순어와 물리적 저장 순서가 일치하지 않아, Search 과정에 있어 어떠한 원소를 삭제 또는 추가하는 작업을 하기위해서 O(n)의 시간이 추가적으로 발생하는 단점이 있다.
        - 따라서, Linked List 자료 구조는 Search, 삽입, 삭제에 대해서도 O(n)의 시간복잡도를 갖는다.
        - Linked List는 Tree 구조의 근간이 되는 자료구조이며, Tree에서 사용되었을 때 유용함이 있다.

    */

    // 각 노드는 자신 다음이 어떤 원소인지만을 기억한다.
    public class Node {
        int data;
        Node next;
    }

    private class SingleLinkedList {
        private  Node head; // 첫 번째 노드 객체 생성

        public void addToHead(int n){
            Node newNode = new Node();
            newNode.data = n;
            head.next = newNode;
            head = newNode;
        }

        /*
         * 첫번째 원소 제거
         * */
        public void removeFirst(){
            if (head == null){
                throw new RuntimeException("Not found");
            }
            Node temp = head;
            head = null;
            head = temp.next;
        }

        /*
         * 중복된 원소 제거
         * */
        public void removeDuplicateElm(){
            Set<Integer> set = new HashSet<>();
            Node prev = null;
            Node start = head; // head에서부터 탐색 시작
            while (start != null){
                if (set.contains(start.data)){
                    if(prev == null){
                        break;
                    }
                    prev.next = start.next;
                } else {
                    set.add(start.data);
                    prev = start;
                }
                start = start.next;
            }
        }

        /*
         * 역순으로 출력
         * */
        public void reverse(){
            Node prev = null;
            Node start = head;
            Node next = null;
            while (start != null) {
                next = start.next;
                start.next = prev;
                prev = next;
            }
        }

        /*
         * k번째 원소 찾기
         * */
        public Node kthRoLast(int k ){
            Node result = head;
            if (k<0){
                return null;
            }
            int count =0;
            while(count < k){
                result = head.next;
                head = head.next;
                count++;
            }
            return result;
        }

        /*
         * 회문인지 판단
         * */
        public boolean isPalindrome(){
            Stack<Node> stack = new Stack<>();
            Node node1 = head;
            Node node2 = head;
            while (node1 != null && node2 != null){
                stack.push(node1);
                node1 = head.next;
                node2 = head.next.next;
            }
            if (node2 != null){ // 홀수인 경우
                node1 = node1.next;
            }
            while (node1 != null){
                if (stack.pop().data != node1.data){
                    return false;
                }
                node1 = node1.next;
            }
            return true;
        }
    }
}
