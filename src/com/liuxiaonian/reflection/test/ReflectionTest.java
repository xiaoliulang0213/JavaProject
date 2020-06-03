package com.liuxiaonian.reflection.test;

import com.liuxiaonian.annotation.annotation.Entity;
import com.liuxiaonian.annotation.annotation.Property;
import com.liuxiaonian.reflection.entity.Person;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    public static void main(String[] args){
        Person person = new Person();
        person.setName("刘小念");
       test(person);
    }

    /**
     *@description 反射测试
     *@author chengpunan
     *@methodParam [object]
     *@return void
     *@date 2020/6/3 14:59
     **/
    public static void test(Object object){
        /******************类操作*******************/
        //获取对象所属类的.class文件
        //已知类名：Class clazz = Class.forName("Person")
        //          Class clazz = Person.class
        //未知类名：Class clazz = object.getClass()
        Class clazz = object.getClass();
        //判断类上是否添加了Entity注解
        boolean claAnnResult = clazz.isAnnotationPresent(Entity.class);
        try {
            /******************属性操作*******************/
            //获取类中的某个属性所有信息映射为Field实例
            Field field = clazz.getDeclaredField("name");
            //判读属性上是否添加了Property注解
            boolean annResult = field.isAnnotationPresent(Property.class);
            //获取添加在该属性上的Property注解
            Property property = field.getAnnotation(Property.class);
            //获取PropertyDescriptor(描述了属性的getter/setter方法)
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
            //获取属性的getter方法
            Method getMethod = propertyDescriptor.getReadMethod();
            //获取属性的setter方法
            Method setMethod = propertyDescriptor.getWriteMethod();
            //获取属性值
            Object value = getMethod.invoke(object);
            /******************注解操作*******************/
            //调用注解中定义的方法，获取相应的属性值
            String name = property.name();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (IntrospectionException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
