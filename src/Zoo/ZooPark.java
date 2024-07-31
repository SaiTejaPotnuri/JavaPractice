package Zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Zoo.Creatures.ZooCreatureModel;
import Zoo.Keeper.ZooKeeper;

public class ZooPark {
   Scanner sc = new Scanner(System.in);
   public List<ZooCreatureModel> animals = new ArrayList<>();
   public List<ZooKeeper> zooKeepers = new ArrayList<>();
   private int option = 1;


   
   public ZooPark(){}
 

   public void doAction(){
    while(this.option<=4 && this.option>=1){
        System.out.println("Select Below Options \n 1.AddCreature \n 2.AddKeeper\n 3.List Of Creatures \n 4.List Of Keepers");
        this.option = sc.nextInt();
        switch (this.option) {
            case 1:
                this.addCreature();
                break;
            case 2:
                this.addKeeper();
                break;
            case 3:
             this.displayAllCreatures();
                break;
            case 4:
                this.displayAllZookeepers();
                break;            
            default:
                break;
        }
    }
   }



    public void addCreature(){}
   
    public void addKeeper(){}

    public void displayAllZookeepers(){}

    public List<ZooCreatureModel> displayAllCreatures(){
        
        this.displayCreaturesByCategory();
        return this.animals;
    }

    public void displayCreaturesByCategory(){}

    

   
    

    
}
