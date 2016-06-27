package com.abin.lee.reflect;

import com.abin.lee.reflect.model.MyModel;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.BooleanMemberValue;
import javassist.bytecode.annotation.StringMemberValue;

import com.abin.lee.reflect.annotation.MyAnnotation;


public class ClassPoolUtils {


    /**
     * 动态修改注解的字段值
     *
     * @param entityClassName   待映射的实体全限定类名
     * @param params         待映射的字段值
     * @return                  映射后的类对象
     */
    public static Class<?> tableMapping(String entityClassName, String... params){
        Class<?> c = null;
        try {
            ClassPool classPool = ClassPool.getDefault();
//            classPool.appendClassPath(new ClassClassPath(ClassPoolUtils.class));
//            classPool.importPackage("com.abin.lee.reflect.model");
            CtClass clazz = classPool.get(entityClassName);
            ClassFile classFile = clazz.getClassFile();

            System.out.println("增强前MyModel:" + clazz.getAnnotation(MyAnnotation.class));

            ConstPool constPool = classFile.getConstPool();
            Annotation tableAnnotation = new Annotation("com.abin.lee.reflect.annotation.MyAnnotation", constPool);
            tableAnnotation.addMemberValue("name", new StringMemberValue(params[0], constPool));
            tableAnnotation.addMemberValue("defaultValue", new BooleanMemberValue(Boolean.parseBoolean(params[1]), constPool));
            // 获取运行时注解属性
            AnnotationsAttribute attribute = (AnnotationsAttribute)classFile.getAttribute(AnnotationsAttribute.visibleTag);
            attribute.addAnnotation(tableAnnotation);
            classFile.addAttribute(attribute);
            classFile.setVersionToJava5();
            clazz.writeFile();

            System.out.println("增强后MyModel:" + clazz.getAnnotation(MyAnnotation.class));
            //TODO 当前ClassLoader中必须尚未加载该实体。（同一个ClassLoader加载同一个类只会加载一次）
            c = clazz.toClass();
            System.out.println("增强后toClass-MyModel:" + c.getAnnotation(MyAnnotation.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    public static void main(String[] args) {
        String[] input = new String[2];
        input[0] = "exchange";
        input[1] = "false";
        ClassPoolUtils.tableMapping("com.abin.lee.reflect.model.MyModel", input);
    }


}