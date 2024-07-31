// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;

import Zoo.ZooPark;
// import Zoo.Creatures.ZooCreatures;
import Zoo.Keeper.ZooKeeper;


// class Animal {
//     int id;
//     String nickname;
//     Date joinedOn;
//     int zooKeeperId;


//     public String readAnimalInfo() {
//         // 
//         // build the animal object using the properties 

//         return "Need TO share a object";
//     }
// }



// class ZooKeeper {
//     int id;
//     String name;
// }

// class Zoo {
//     List<Animal> animals;

//     List<ZooKeeper> zooKeepers;

//     public Zoo() {
//         this.animals = new ArrayList<>();
//         this.zooKeepers = new ArrayList<>();
//     }

//     public void addAnimal(Animal animal) {
//         this.animals.add(animal);
//     }

//     public void removeAnimal(Animal animal) {
//         this.animals.remove(animal);
//     }

//     public void addZooKeeper(ZooKeeper zooKeeper) {
//         this.zooKeepers.add(zooKeeper);
//     }

//     public void removeZooKeeper(ZooKeeper zooKeeper) {
//         this.zooKeepers.remove(zooKeeper);
//     }

// }

// class ZooParkCli {
//     public void showMenu(){

//     }

//     public int readInput() {
//         return 0;
//     }

//     public void processInput(int option) {
//         switch (option) {
//             case 1:
//                 Animal animal = readAnimalInfo();
//                 new Zoo().addAnimal(animal);
//                 break;
        
//             default:
//                 break;
//         }
//     }

//    public Animal readAnimalInfo() {
//         // 


//         // build the animal object using the properties 
//         return null;
//     }

    

// }

public class Main{
    public static void main(String[] args) {
        System.out.println("Welcome to ZooPark");
        ZooPark zooPark = new ZooKeeper();
       zooPark.doAction();
        
    }
}