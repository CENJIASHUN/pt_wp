package com.chen.jason.stu.java8;

/**
 * Created on 2019/4/4. By CenJS
 *
 * 方法引用通过方法的名字来指向一个方法
 * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码
 * 方法引用使用一对冒号 ::
 */
public class Java8MethodInterface {

        @FunctionalInterface
        public interface Supplier<T> {
            T get();
        }

        //Supplier是jdk1.8的接口，这里和lamda一起使用了
        public static Java8MethodInterface create(final Supplier<Java8MethodInterface> supplier) {
            return supplier.get();
        }

        public static void collide(final Java8MethodInterface car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Java8MethodInterface another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }
/*构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：

final Car car = Car.create( Car::new );
final List< Car > cars = Arrays.asList( car );
静态方法引用：它的语法是Class::static_method，实例如下：

cars.forEach( Car::collide );
特定类的任意对象的方法引用：它的语法是Class::method实例如下：

cars.forEach( Car::repair );
特定对象的方法引用：它的语法是instance::method实例如下：

final Car police = Car.create( Car::new );
cars.forEach( police::follow );*/
}
