package Zoo.Creatures;

import Zoo.ZooPark;

public class ZooCreatureModel extends ZooPark {

    
    public int code;
    public String name;
    public String DOJ;
    public String zooKeeper;

    public ZooCreatureModel(){}

    public ZooCreatureModel(int code,String name,String DOJ,String zooKeeper){
        this.code = code;
        this.name = name;
        this.DOJ = DOJ; 
        this.zooKeeper = zooKeeper;
    }

    @Override
    public String toString() {
        return "Creature code= " + code + ", name= " + name + ", DOJ= " + DOJ + ", zooKeeper= " + zooKeeper;
    }
    
}
