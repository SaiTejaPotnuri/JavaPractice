package Zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Zoo.Creatures.*;
import Zoo.Keeper.ZooKeeper;


public class ZooPark {
    Scanner sc = new Scanner(System.in);
    public List<ZooCreatureModel> animals = new ArrayList<>();
    public List<ZooKeeper> zooKeepers = new ArrayList<>();
    private int option = 1;
    private ZooCreatures zooCreatures;
    private ZooKeeper zooKeeperObj;

    public ZooPark() {
        this.zooCreatures = new ZooCreatures(animals, zooKeepers);
        this.zooKeeperObj = new ZooKeeper(zooKeepers);
    }

    public void open() {
        while (this.option <= 4 && this.option >= 1) {
            System.out.println("Select Below Options \n 1.AddCreature \n 2.AddKeeper\n 3.List Of Creatures \n 4.List Of Keepers");
            this.option = sc.nextInt();
            switch (this.option) {
                case 1:
                    this.zooCreatures.addCreature();
                    break;
                case 2:
                    this.zooKeeperObj.addKeeper();
                    break;
                case 3:
                    this.zooCreatures.displayCreaturesByCategory();
                    break;
                case 4:
                    this.zooKeeperObj.displayAllZookeepers(animals);
                    break;
                default:
                    break;
            }
        }
    }
}