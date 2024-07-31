package Zoo.Creatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Zoo.ZooPark;
import Zoo.Creatures.Enums.*;

public class ZooCreatures extends ZooPark {

    public int creatureOpt;

    Map<String, List<ZooCreatureModel>> mammals = new HashMap<String, List<ZooCreatureModel>>();
    Map<String, List<ZooCreatureModel>> birds = new HashMap<String, List<ZooCreatureModel>>();
    Map<String, List<ZooCreatureModel>> waterCreatures = new HashMap<String, List<ZooCreatureModel>>();
    ZooCreatureCLI zooCreaCli = new ZooCreatureCLI();
    ZooCreatureModel newCreature = new ZooCreatureModel();

    public ZooCreatures() {
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

    @Override
    public void addCreature() {
        this.processCreature(zooCreaCli.getCreatureType());
    }

    @Override
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
            }
            if(map.get(key) != null){
                for(ZooCreatureModel zcm : map.get(key)){
                    System.out.println("Code : "+zcm.code+" , Name : "+zcm.name+" , Date of Joining : "+zcm.DOJ+" , Keeper Code : "+zcm.zooKeeper);
                }
            }
        }
    }




    public void processCreature(int option) {
        switch (option) {
            case 1:
                System.out.println("Mammals List of Zoo \n 1. LIONS \n 2. TIGERS \n 3. ELEPHANTS");
                CreatureMammals[] mamEnums = CreatureMammals.values();
                this.updateCreatures(mamEnums,mammals,"mammals");
                break;
            case 2:
                System.out.println("Birds List of Zoo \n 1. PARROTS \n 2. EAGLE \n 3. SPARROW");
                CreatureBirds[] birdEnums = CreatureBirds.values();
                this.updateCreatures(birdEnums,birds,"birds");
                break;
            case 3:
                System.out.println("Water Creatures List of Zoo \n 1. SHARKS \n 2. DOLPHINS \n 3. SEA LIONS");
                CreatureFish[] waterCreatureEnums = CreatureFish.values();
                this.updateCreatures(waterCreatureEnums,waterCreatures,"waterCreatures");         
                break;
            default:
                break;
        }
    }

    public void updateCreatures(Enum[] creatureEnums, Map<String, List<ZooCreatureModel>> creature,String category) {
        String type = creatureEnums[zooCreaCli.readCreatureType() - 1].name();
        List<ZooCreatureModel> list = creature.get(type);
        if (list == null) {
            list = new ArrayList<>();
        }
        newCreature = zooCreaCli.addCreatureInfo();
        list.add(new ZooCreatureModel(newCreature.code, newCreature.name, newCreature.DOJ, newCreature.zooKeeper));
        if (this.animals == null) {
            this.animals = new ArrayList<>();
        }
        this.animals
                .add(new ZooCreatureModel(newCreature.code, newCreature.name, newCreature.DOJ, newCreature.zooKeeper));
                if(category.equals("mammals")){
                    this.mammals.put(type, list);
                }   else if (category.equals("birds")){
                    this.birds.put(type, list);
                }   else if (category.equals("waterCreatures")){
                    this.waterCreatures.put(type, list);   
                }
    }

}
