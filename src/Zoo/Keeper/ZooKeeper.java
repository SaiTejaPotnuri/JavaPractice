package Zoo.Keeper;

import java.util.List;
import java.util.Scanner;

import Zoo.Creatures.*;

public class ZooKeeper  {

    public int id;
    public String name;
    Scanner sc = new Scanner(System.in);
    public List<ZooKeeper> zooKeepers;
    public ZooKeeper(){}
    public ZooKeeper(List<ZooKeeper> zooKeepers) {
        this.zooKeepers = zooKeepers;
    }
    public ZooKeeper(int id,String name){
        this.id = id;
        this.name = name;
    }

    public void addKeeper(){
        System.out.println("Enter Keeper Id");
        this.id = sc.nextInt();
        System.out.println("Enter Keeper Name");
        this.name = sc.next();
        this.zooKeepers.add(new ZooKeeper(this.id, this.name.toLowerCase()));
    }

    public void displayAllZookeepers(List<ZooCreatureModel> animals){
        System.out.println("Total Zookepers : " +this.zooKeepers.size());
        for(ZooKeeper zk : this.zooKeepers){
            System.out.println("Id : "+zk.id+" Name : "+zk.name +" Assigned AnimalCount : "+animals.stream().filter(ani -> ani.zooKeeper.equals(zk.name)).count());
        }
        if (animals.size() > 3 && zooKeepers.size() > 1) {
            System.out.println("Average animals per Zookeeper: " + animals.size() / zooKeepers.size());
        }
    }
    
}
