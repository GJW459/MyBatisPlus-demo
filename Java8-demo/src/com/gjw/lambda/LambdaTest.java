package com.gjw.lambda;

import com.gjw.functionInterface.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 复习Lambda表达式
 * java8的新特性
 * 可以替代大量的匿名函数->优化代码结构
 * JDK提供了大量的内置函数式接口
 * 使用Lambda表达式的使用更加方便,代码更简单
 * Lambda可以对某些接口进行简单的实现
 * 但是并不是所有的接口都可以使用Lambda表达式来实现
 * Lambda规定接口只能有一个方法需要被实现,不是规定接口中只有一个方法
 * java8 另一个特性 default,被default修饰的方法都会有默认实现,不是必须被实现的方法
 * 本质就是接口实现类的对象
 * @FunctionalInterface 修饰函数式接口 要求接口中的抽象方法只有一个 这个注解往往和Lambda表达式一起出
 * Lambda 6 种格式
 * Lambda 表达式引用方法
 *
 *  * Java内置四大核心函数式接口
 *  * Consumer<T> 参数类型T 返回类型void 消防型接口 对类型为T的对象进行操作,包含方法:accept(T t)
 *  * Supplier<T> 参数类型无 返回类型T 供给型接口 返回类型为T的对象,包含方法T get()
 *  * Function<T,R> 参数类型T 返回类型R 函数型接口 对类型为T的进行操作,返回类型为R的对象 R apply(T t)
 *  * Predicate<T> 参数类型T 返回类型 boolean 断定型接口 确定类型为T的对象是否满足某种约束,并返回boolean值 boolean test(T t)
 */
public class LambdaTest {

    /**
     * 要求
     * 1.参数数量和类型要与接口中的定义一致
     * 2.返回类型也得一致
     * @param a
     * @return
     */
    public static int doubleNum(int a){
        return a*2;
    }
    public int addTwo(int a){
        return a+2;
    }

    public static void main(String[] args) {

        //如实现Runnable接口
        //默认
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("哈哈哈");
            }
        };
        //lambda实现
        Runnable runnable1=()-> System.out.println("哈哈哈");
        runnable.run();
        runnable1.run();
        //第一种 无返回多参数
        NoReturnMultiParam noReturnMultiParam=(a,b)->{
            int sum=a+b;
            System.out.println(a+b);
        };
        noReturnMultiParam.method(1,2);
        //第二种 无返回一参数
        NoReturnOneParam noReturnOneParam=a -> System.out.println(a);
        noReturnOneParam.method(2);
        //第三中 无返回无参数
        NoReturnNoParam noReturnNoParam=()-> System.out.println("来了老铁");
        //第四种 有返回多参数
        ReturnMultiParam returnMultiParam=(a,b)->a+b;
        System.out.println(returnMultiParam.method(1,2));
        ReturnOneParam returnOneParam=a->a+3;
        System.out.println(returnOneParam.method(3));
        ReturnNoParam returnNoParam=()-> 3;
        System.out.println(returnNoParam.method());
        //lambda 引用方法
        ReturnOneParam returnOneParam1=a->doubleNum(a);
        System.out.println(returnOneParam1.method(1));
        //引用静态方法
        ReturnOneParam returnOneParam2=LambdaTest::doubleNum;
        System.out.println(returnOneParam2.method(2));
        LambdaTest lambdaTest = new LambdaTest();
        //引用对象方法
        ReturnOneParam returnOneParam3=lambdaTest::addTwo;
        System.out.println(returnOneParam3.method(2));
        //引用构造器
        //创建线程
        Thread thread=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });
        thread.start();
        //遍历集合
        ArrayList<Integer> arrayList=new ArrayList<>();
        Collections.addAll(arrayList,1,3,7,2,3,4,5);
        System.out.println("======");
        //lambda表达式 方法引用
        arrayList.forEach(System.out::println);
        System.out.println("=======");
        arrayList.forEach(element->{
            if (element%2==0){
                System.out.println(element);
            }
        });
        //删除 指定 元素
        System.out.println("===========");
        arrayList.removeIf(element->element==2);
        arrayList.forEach(System.out::println);
        //排序
        arrayList.sort(Integer::compareTo);


    }
}
