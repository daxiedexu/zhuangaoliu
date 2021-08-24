package com.example.mvvm_core.repository;

import com.example.mvvm_core.common.MVVMModelException;
import com.example.mvvm_core.model.Model;

import java.lang.reflect.Field;

/**
 * @ClassName BaseRepository
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/16 18:38
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public abstract class BaseRepository {
    public BaseRepository() {
        injectModel();
    }

    private void injectModel() {
        //拿到它的类
        Class<? extends BaseRepository> aClass = this.getClass();
        //拿到它里面所有的属性
        Field[] declaredFields = aClass.getDeclaredFields();
        if (declaredFields==null||declaredFields.length==0){
            throw new MVVMModelException("no have any fields info...");
        }
        boolean flag = false;
        for (Field field:declaredFields){
            Model annotation = field.getAnnotation(Model.class);
            if (annotation!=null){
                flag=true;
                //关闭安全属性
                field.setAccessible(true);
                String fieldClassName = field.getType().getName();
                try {
                    Class<?> fieldClass = Class.forName(fieldClassName);
                    Object fieldInstance = fieldClass.newInstance();
                    field.set(this,fieldInstance);
                } catch (ClassNotFoundException e) {
                    throw new MVVMModelException(e.getMessage());
                } catch (IllegalAccessException e) {
                    throw new MVVMModelException(e.getMessage());
                } catch (InstantiationException e) {
                    throw new MVVMModelException(e.getMessage());
                }
            }
        }
        if (!flag){
            throw new MVVMModelException("not set any Model...");
        }
    }
}
