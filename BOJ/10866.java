import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class Node
    {
        int data;
        Node prev, next;

        static Node getnode(int data)
        {
            Node newNode = new Node();
            newNode.data = data;
            newNode.prev = newNode.next = null;
            return newNode;
        }
    }

    static class Deque {
        Node front;
        Node rear;
        int Size;

        Deque()
        {
            front = rear = null;
            Size = 0;
        }

        void push_front(int data)
        {
            Node newNode = Node.getnode(data);
            if (newNode == null)
                System.out.print("OverFlow\n");
            else {
                if (front == null)
                    rear = front = newNode;
                else {
                    newNode.next = front;
                    front.prev = newNode;
                    front = newNode;
                }
                Size++;
            }
        }

        void push_back(int data)
        {
            Node newNode = Node.getnode(data);
            if (newNode == null)
                System.out.print("OverFlow\n");
            else {
                if (rear == null)
                    front = rear = newNode;
                else {
                    newNode.prev = rear;
                    rear.next = newNode;
                    rear = newNode;
                }
                Size++;
            }
        }

        int pop_front()
        {
            if (empty()==1)
                return -1;
            else {
                Node temp = front;
                front = front.next;
                if (front == null)
                    rear = null;
                else
                    front.prev = null;
                Size--;
                return temp.data;
            }
        }

        int pop_back()
        {
            if (empty()==1)
                return -1;
            else {
                Node temp = rear;
                rear = rear.prev;

                if (rear == null)
                    front = null;
                else
                    rear.next = null;
                Size--;
                return temp.data;
            }
        }

        int size() { return Size; }

        int empty() {
            if (front==null)
                return 1;
            else
                return 0;
        }

        int front()
        {
            if (empty()==1)
                return -1;
            return front.data;
        }

        int back()
        {
            if (empty()==1)
                return -1;
            return rear.data;
        }
    }

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque deque = new Deque();

        for (int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch(cmd){
                case "push_front":
                    deque.push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(deque.pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.pop_back()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.empty()).append("\n");
                    break;
                case "front":
                    sb.append(deque.front()).append("\n");
                    break;
                case "back":
                    sb.append(deque.back()).append("\n");
                    break;
            }
        }
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
