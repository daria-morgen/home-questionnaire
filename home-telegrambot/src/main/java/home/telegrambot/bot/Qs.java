package home.telegrambot.bot;

import java.text.SimpleDateFormat;
import java.util.*;
public class Qs {

    public static void quickSort(List<Register> array, int low, int high) {
        if (array.size() == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Register opora = array.get(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {

            while (array.get(i).priority < opora.priority
//                    || (array.get(i).priority == opora.priority && array.get(i).operDate < opora.operDate)
                    || (array.get(i).priority == opora.priority && array.get(i).operDate == opora.operDate && array.get(i).createDate < opora.createDate)) {
                i++;
            }

            while (array.get(j).priority > opora.priority
//                    || (array.get(j).priority == opora.priority && array.get(j).operDate > opora.operDate)
                    || (array.get(j).priority == opora.priority && array.get(j).operDate == opora.operDate && array.get(j).createDate > opora.createDate)) {
                j--;
            }



            if (i <= j) {//меняем местами
//                if(array.get(i).priority!=array.get(j).priority){
                    Register temp = array.get(i);
                    array.set(i,array.get(j));
                    array.set(j,temp);
//                }else {
//                    if(array.get(i).operDate!=array.get(j).operDate){
//                        if(array.get(i).operDate < array.get(j).operDate){
//                            Register temp = array.get(i);
//                            array.set(i,array.get(j));
//                            array.set(j,temp);
//                        }
//
//                    }else {
//                        if(array.get(i).createDate!=array.get(j).createDate){
//                            if(array.get(i).createDate > opora.createDate){
//                                Register temp = array.get(i);
//                                array.set(i,array.get(j));
//                                array.set(j,temp);
//
//                            }
//                        }
//                    }
//                }

                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");


        List<Register> registers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
//            registers.add(new Register( (int)(i*Math.random()), new Date((long)(1212121212121L*Math.random())), new Date((long)(1212121212121L*Math.random()))));


            registers.add(new Register( (int)(i*Math.random()),1,  (int)(10*Math.random())));
        }


        System.out.println("Было");
        registers.forEach(e-> System.out.println("priotity: "+e.priority+", operDate: "+e.operDate+", createDate: "+e.createDate));

        int low = 0;
        int high = registers.size() - 1;

        quickSort(registers, low, high);
        System.out.println("Стало");
        registers.forEach(e-> System.out.println("priotity: "+e.priority+", operDate: "+e.operDate+", createDate: "+e.createDate));

    }

    public static void quickSort(int[] arr) {
        int subArray = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0); // left
        stack.push(arr.length - 1); // right
        do {
            int right = stack.pop();
            int left = stack.pop();
            --subArray;
            do {
                int _left = left;
                int _right = right;
                int pivot = arr[(left + right) / 2];
                do {
                    while (pivot < arr[_right]) {
                        _right--;
                    }
                    while (pivot > arr[_left]) {
                        _left++;
                    }
                    if (_left <= _right) {
                        if (_left != _right) {
                            int temp = arr[_left];
                            arr[_left] = arr[_right];
                            arr[_right] = temp;
                        }
                        _right--;
                        _left++;
                    }
                } while (_right >= _left);
                if (_left < right) {
                    ++subArray;
                    stack.push(_left);
                    stack.push(right);
                }
                right = _right;
            } while (left < right);
        } while (subArray > -1);
    }
}

class Register {

    int priority;

    int operDate;

    int createDate;

    public Register(int priority, int operDate, int createDate) {
        this.priority = priority;
        this.operDate = operDate;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Register{" +
                "priority=" + priority +
                ", operDate=" + operDate +
                ", createDate=" + createDate +
                '}';
    }
}