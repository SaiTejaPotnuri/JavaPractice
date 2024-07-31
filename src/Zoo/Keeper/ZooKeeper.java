package Zoo.Keeper;

import java.util.Scanner;

import Zoo.Creatures.ZooCreatures;

public class ZooKeeper extends ZooCreatures {

    public int id;
    public String name;
    Scanner sc = new Scanner(System.in);
    public ZooKeeper(){}
    public ZooKeeper(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public void addKeeper(){
        System.out.println("Enter Keeper Id");
        this.id = sc.nextInt();
        System.out.println("Enter Keeper Name");
        this.name = sc.next();
        this.zooKeepers.add(new ZooKeeper(this.id, this.name.toLowerCase()));
        System.out.println(this.zooKeepers + "Zoo keepers");
    }

    @Override
    public void displayAllZookeepers(){
        System.out.println("Total Zookepers : " +this.zooKeepers.size());
        for(ZooKeeper zk : this.zooKeepers){
            System.out.println("Keeper Id : "+zk.id+" Keeper Name : "+zk.name +" Assigned AnimalCount : "+this.animals.stream().filter(ani -> ani.zooKeeper.equals(zk.name)).count());
        }
        if(this.animals.size() > 3 && this.zooKeepers.size() > 1){
            System.out.println("Average animal for Zookeper : "+this.animals.size()/this.zooKeepers.size());
        }
    }
    
}
