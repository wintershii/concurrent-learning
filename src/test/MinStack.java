package test;

import java.util.Comparator;

@SuppressWarnings("all")
public class MinStack<T> {
    private T[] arr;
    private int top;
    private Comparator<T> comparator;

    public MinStack(Comparator<T> comparator) {
        arr = (T[]) new Object[1000];
        top = 0;
        this.comparator = comparator;
    }

    public void push(T obj) {
        if (top == 0) {
            arr[top++] = obj;
        } else {
            if (comparator.compare(arr[0],obj) > 0) {
                arr[0] = obj;
            }
        }
        arr[top++] = obj;
    }

    public T pop() {
        T tmp = arr[--top];
        arr[top] = null;
        if (tmp.equals(arr[0])) {
            arr[0] = null;
            for (int i = 1; i < top; ++i) {
                if (arr[0] == null || (comparator.compare(arr[0],arr[i])) > 0) {
                    arr[0] = arr[i];
                }
            }
        }
        return tmp;
    }

    public T getTop() {
        return arr[top-1];
    }

    public T getMin() {
        return arr[0];
    }


    public static void main(String[] args) {
        MinStack<Student> stack = new MinStack<>(Comparator.comparing(o -> o.name));
        stack.push(new Student(12,"shidongxuan"));
        stack.push(new Student(13,"zhangshuo"));
        stack.push(new Student(14,"haojianqiang"));
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
    }
}

class Student {
    int num;
    String name;

    public Student(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
