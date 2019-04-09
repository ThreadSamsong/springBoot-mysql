package com.samsong.readwrite.springbootmysql.config.mysql;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(com.samsong.readwrite.springbootmysql.config.mysql.DS)")
    public void beforeSwithDS(JoinPoint point){
        //获取当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获取访问的方法名
        String methodName =point.getSignature().getName();
        //获取方法的参数类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String datasource = DataSourceContextHolder.DEFAULT_DS;
        try{
            //得到访问的方法对象
            Method method = className.getMethod(methodName,argClass);
            //判断是否存在@DS注解
            if(method.isAnnotationPresent(DS.class)){
                DS annotation = method.getAnnotation(DS.class);
                //取出注解中的数据源名
                datasource = annotation.value();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //切换数据源
        DataSourceContextHolder.setDB(datasource);
    }

    @After("@annotation(com.samsong.readwrite.springbootmysql.config.mysql.DS)")
    public void afterSwithDS(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}
