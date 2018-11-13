package io.ibicfly.service0;

import javax.validation.constraints.Null;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {
        //这样获取现在这个实例对象的
        Test1 test=new Test1();
        Test1 test2=new Test1();

        Class testClass=test.getClass();
        Class testClass2=test2.getClass();
        System.out.println("testClass对应class"+testClass.getName());
        System.out.println("testClass2对应class"+testClass2.getName());
        System.out.println(testClass==testClass2);
        //想知道的是很多时候利用反射实现CGLIB代理，还有SpringAOP原理，DI原理
        Student student=new Student("def");
        Constructor[] publicConstructors=student.getClass().getConstructors();
        Constructor[] allConstructors=student.getClass().getDeclaredConstructors();

        System.out.println("总共有"+publicConstructors.length+"个公有构造方法");
        System.out.println("总共有"+allConstructors.length+"个构造方法");
        for(Constructor temp:allConstructors)
        {
            System.out.println(temp);
        }
        long start=System.nanoTime();
        String a="1213333333333333333333333333333333333333333333333331:a11233333333333333333333333333333asdffffffffffdaszvcxzvadfgsdfasdfasdfasdhfjklashdjfkahsjdkflahjsdkflahsjkfdlzxycuvioycvbnbm,werbwe.,ymnweoputr/sd,v.nmosdafjqw;lrjiqwpoutrq[weporiwretioruawp[oeirqwpeo[riqwoepriwoieropq[weiro[qweriopq[weroioqp[ewrittn:ame";
        String temp="1";
        for(int i=0;i<Integer.MAX_VALUE;i++)
        {
            temp+=i;
        }
        System.out.println(temp.length());
        int index=a.indexOf(":");
        System.out.println(a.substring(0,index));
        System.out.println(a.substring(index+1));
        System.out.println("耗时"+(System.nanoTime()-start)+"ns");
        //

    }
}
class Test1{

}
class Student {

    //---------------构造方法-------------------
    //（默认的构造方法）
    Student(String str){
        System.out.println("(默认)的构造方法 s = " + str);
    }

    //无参构造方法
    public Student(){
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }

    //有一个参数的构造方法
    public Student(char name){
        System.out.println("姓名：" + name);
    }

    //有多个参数的构造方法
    public Student(String name ,int age){
        System.out.println("姓名："+name+"年龄："+ age);//这的执行效率有问题，以后解决。
    }

    //受保护的构造方法
    protected Student(boolean n){
        System.out.println("受保护的构造方法 n = " + n);
    }

    //私有构造方法
    private Student(int age){
        System.out.println("私有的构造方法   年龄："+ age);
    }

}
