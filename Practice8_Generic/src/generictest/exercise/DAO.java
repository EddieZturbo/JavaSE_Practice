package generictest.exercise;

import java.util.*;

/**
 * @author EddieZhang
 * @create 2022-08-16 19:46
 */
/*
定义个泛型类 DAO<T>，在其中定义一个 Map 成员变量，Map 的键为 String 类型，值为 T 类型
 */
public class DAO <T>{
    private Map<String,T> map = new HashMap<String,T>();
    //保存 T 类型的对象到 Map 成员变量中
    public void save(String id,T entity){
        map.put(id,entity);
    }
    //从 map 中获取 id 对应的对象
    public T get(String id){
        T t = map.get(id);
        return t;
    }
    //替换 map 中 key 为 id 的内容,改为 entity 对象
    public void update(String id,T entity){
        if(map.containsKey(id)){
            map.put(id,entity);
        }

    }
    //返回 map 中存放的所有 T 对象
    public List<T> list(){
        Collection<T> values = map.values();//此时返回的是Collection--无法直接强转成List
        ArrayList<T> arrayList = new ArrayList<T>();//new一个List
        //通过遍历Collection<T> values = map.values()赋值给new的List
        for (T arraylist1 :
                values) {
            arrayList.add(arraylist1);
        }
        return arrayList;
    }
    //删除指定 id 对象
    public void delete(String id){
        map.remove(id);
    }
}
