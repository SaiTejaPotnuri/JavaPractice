package Zoo.Creatures;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class ZooCreatureCLI extends ZooCreatureModel {


    Scanner st = new Scanner(System.in);
    private Boolean flag;

    public int getCreatureType(){
        System.out.println("Select Creature \n 1.Mammals \n 2.Birds \n 3.Fish");
        return readCreatureType();
    }

    public int readCreatureType(){
        return st.nextInt();   
    }


     public ZooCreatureModel addCreatureInfo() {
            System.out.println("Please enter Creature Code");
            this.code = st.nextInt();
            System.out.println("Please enter Creature Name");
            this.name = st.next();
            System.out.println("Please enter Creature Date of joining in the format DD/MM/YYYY");
            this.DOJ = st.next();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
            sdf.setLenient(false);
            do {
                try{
                    this.flag = false;
                    sdf.parse(DOJ);
                }catch(Exception e){
                    this.flag = true;
                    System.out.println("Please enter valid date of joining in the format DD/MM/YYYY");
                    this.DOJ = st.next();
                }
            }while (flag);
            System.out.println("Please enter Zoo Keeper name ");
            this.zooKeeper = st.next();
            if(!this.zooKeepers.stream().anyMatch(zk -> zk.name.equals(this.zooKeeper.toLowerCase())) || this.zooKeeper == null){
                this.zooKeeper = "";
                System.out.println("Zoo Keeper not found , Default value assigned");
            }
            return new ZooCreatureModel(this.code,this.name,this.DOJ,this.zooKeeper);
        }

  
    
    
}
