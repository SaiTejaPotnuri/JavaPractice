package Zoo.Creatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Zoo.Creatures.Enums.*;
import Zoo.Keeper.*;

public class ZooCreatures  {

    private List<ZooCreatureModel> animals;

    Map<String, List<ZooCreatureModel>> mammals = new HashMap<String, List<ZooCreatureModel>>();
    Map<String, List<ZooCreatureModel>> birds = new HashMap<String, List<ZooCreatureModel>>();
    Map<String, List<ZooCreatureModel>> waterCreatures = new HashMap<String, List<ZooCreatureModel>>();
    ZooCreatureCLI zooCreaCli;

    public ZooCreatures(List<ZooCreatureModel> animals,List<ZooKeeper> zooKeepers) {
        this.animals = animals;
        this.zooCreaCli = new ZooCreatureCLI(zooKeepers);
        // Mammals
        mammals.put("LIONS", null);
        mammals.put("TIGERS", null);
        mammals.put("ELEPHANTS", null);

        // Birds
        birds.put("PARROTS", null);
        birds.put("EAGLE", null);
        birds.put("SPARROW", null);

        // waterCreatures
        waterCreatures.put("SHARKS", null);
        waterCreatures.put("DOLPHINS", null);
        waterCreatures.put("SEALIONS", null);

    }

    public void addCreature() {
        this.processCreature(zooCreaCli.getCreatureType());
    }

    public void displayCreaturesByCategory(){
        System.out.println("Zoo Total Creatures : " + this.animals.size());
       this.displayCreaturesByType(mammals);
       this.displayCreaturesByType(birds);
       this.displayCreaturesByType(waterCreatures);
    }


    public void displayCreaturesByType(Map<String, List<ZooCreatureModel>> map) {
        for(String key : map.keySet()){
            if(map.get(key) != null){
                System.out.println("Creature Type : "+key+"("+map.get(key).size()+")");
                for(ZooCreatureModel zcm : map.get(key)){
                    System.out.println("Code : "+zcm.code+" , Name : "+zcm.name+" , Date-of-Joining : "+zcm.DOJ+" , Zoo-Keeper : "+zcm.zooKeeper);
                }
            }
        }
    }




    public void processCreature(int option) {
        switch (option) {
            case 1:
                System.out.println("Mammals List of Zoo \n 1. LIONS \n 2. TIGERS \n 3. ELEPHANTS");
                this.updateCreatures(CreatureMammals.values(),mammals);
                break;
            case 2:
                System.out.println("Birds List of Zoo \n 1. PARROTS \n 2. EAGLE \n 3. SPARROW");
                this.updateCreatures(CreatureBirds.values(),birds);
                break;
            case 3:
                System.out.println("Water Creatures List of Zoo \n 1. SHARKS \n 2. DOLPHINS \n 3. SEA LIONS");
                this.updateCreatures(CreatureFish.values(),waterCreatures);         
                break;
            default:
                break;
        }
    }

    public void updateCreatures(Enum<?>[] creatureEnums, Map<String, List<ZooCreatureModel>> creature) {
        String type = creatureEnums[zooCreaCli.readCreatureType() - 1].name();
        List<ZooCreatureModel> list = creature.get(type);
        if (list == null) {
            list = new ArrayList<>();
        }
        ZooCreatureModel newCreature = zooCreaCli.addCreatureInfo();
        list.add(new ZooCreatureModel(newCreature.code, newCreature.name, newCreature.DOJ, newCreature.zooKeeper));
        if (this.animals == null) {
            this.animals = new ArrayList<>();
        }
        this.animals.add(newCreature);
        creature.put(type, list);
    
    }

}
