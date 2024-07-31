package Zoo.Creatures;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import Zoo.Keeper.*;

public class ZooCreatureCLI  {


    Scanner st = new Scanner(System.in);
    private List<ZooKeeper> zooKeepers;

    ZooCreatureModel model = new ZooCreatureModel();
    public ZooCreatureCLI(){}
    public ZooCreatureCLI(List<ZooKeeper> zooKeepers) {
        this.zooKeepers = zooKeepers;
    }

    public int getCreatureType(){
        System.out.println("Select Creature \n 1.Mammals \n 2.Birds \n 3.Fish");
        return readCreatureType();
    }

    public int readCreatureType(){
        return st.nextInt();   
    }


     public ZooCreatureModel addCreatureInfo() {
            System.out.println("Please enter Creature Code");
            this.model.code = st.nextInt();
            System.out.println("Please enter Creature Name");
            this.model.name = st.next();
            System.out.println("Please enter Creature Date of joining in the format DD/MM/YYYY");
            this.model.DOJ = st.next();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy", Locale.US);
            sdf.setLenient(false);
            while (true) {
                try {
                    sdf.parse(model.DOJ);
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter valid date of joining in the format DD/MM/YYYY");
                    model.DOJ = st.next();
                }
            }
            System.out.println("Please enter Zoo Keeper name ");
            this.model.zooKeeper = st.next();
            if(this.zooKeepers.stream().noneMatch(zk -> zk.name.equals(this.model.zooKeeper.toLowerCase())) || this.zooKeepers == null){
                this.model.zooKeeper = "";
                System.out.println("Zoo Keeper not found , Default value assigned");
            }
            return new ZooCreatureModel(this.model.code,this.model.name,this.model.DOJ,this.model.zooKeeper.toLowerCase());
        }

  
    
    
}
