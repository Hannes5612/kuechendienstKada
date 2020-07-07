package personal;

public class members {
    String name ="haus";
    int age;
    static members[] teilnehmer = new members[18];

    public static void main() {
        teilnehmer[0]= new members("horst",20);
        teilnehmer[1]= new members("edgar",18);
        teilnehmer[2]= new members("susanne",11);
        teilnehmer[3]= new members("timo",19);
        teilnehmer[4]= new members("angelina",22);
        teilnehmer[5]= new members("otto",21);
        teilnehmer[6]= new members("tim",20);
        teilnehmer[7]= new members("janine",22);
        teilnehmer[8]= new members("diane",22);
        teilnehmer[9]= new members("bianca",18);
        teilnehmer[10]= new members("leon",16);
        teilnehmer[11]= new members("vincenco",32);
        teilnehmer[12]= new members("katharina",24);
        teilnehmer[13]= new members("fridah",22);
        teilnehmer[14]= new members("lion",25);
        teilnehmer[15]= new members("brian",20);
        teilnehmer[16]= new members("donald",21);
        teilnehmer[17]= new members("angela",20);
    }
    public members(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        if (name!=null) return name;
        return "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
