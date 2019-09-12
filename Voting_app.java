
package voting_app;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fami
 */

abstract class election{
    abstract public int vote();
} 

class voters extends election{
    String name;
    int id;
    Boolean flag=false;

    public voters() {
    }

    public voters(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public int vote(){
    //if flag false then let him vote from 2 hardcoded or so candidate
    if(flag==false)
    {
        flag=true;
        Scanner in=new Scanner(System.in);
        System.out.println("\n\nwhom do you want to vote for?\n6:Imran khan\n7:Nawaz Sharif");
        int n=in.nextInt();
        return n;
    }
    else
        return 0;
        
    }
    
    public void print(){
        System.out.println(id+". "+name);
    }
}

class candidate extends election{
    String name;
    int id;
    Boolean flag=false;
    int total_votes=0;

    public candidate() {
    }

    public candidate(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public int vote(){
        //same function as of user
    if(flag==false){
        flag=true;
        Scanner in=new Scanner(System.in);
        System.out.println("\n\nwhom do you want to vote for?\n6:Imran khan\n7:Nawaz Sharif");
        int n=in.nextInt();
        return n;
    }
    else
        return 0;
    }
    public void print(){
        System.out.println(id+". "+name);
    }
}

abstract class notification{
    
    abstract void print();
    
}

class sms extends notification{
    
    void print(){
        System.out.println("\nSms generated, voting is closed.");
    }
    
}

class email extends notification{
    
    void print(){
        System.out.println("\nEMAIL generated, voting is closed.");
    }
    
}

public class Voting_app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //add check of 6pm(make list of user and candidate,ask id, cast vote,add total votes of voters)
        
        List<voters>vt=new ArrayList<voters>();
        List<candidate>cd=new ArrayList<candidate>();
        
        voters v1=new voters("faheem",1);
        voters v2=new voters("danish",2);
        voters v3=new voters("hammad",3);
        voters v4=new voters("shazar",4);
        voters v5=new voters("muhammad",5);
        
        candidate c1=new candidate("Imran khan",1);
        candidate c2=new candidate("Nawaz Sharif",2);
        
        vt.add(v1);
        vt.add(v2);
        vt.add(v3);
        vt.add(v4);
        vt.add(v5);
        
        cd.add(c1);
        cd.add(c2);
        
        Boolean t=false;
        
        sms k1=new sms();
        email k2=new email();
        
        LocalDateTime now=LocalDateTime.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("HH");
        String formatDateTime=now.format(format);
        
        System.out.println("-:Voters list:-");
        for(int i=0;i<7;i++)
        {
            if(i==5){
                System.out.println("\n-:Candidates list:-");
                cd.get(0).print();
            }
            else if(i==6)
            {
                cd.get(1).print();
            }
            else
                vt.get(i).print();
        }
        
        for(int i=0;i<7&&t==false;i++)
        {
            if(formatDateTime.contains("6")==true)
            {
                t=true;
            }
            else
            {
                Scanner in=new Scanner(System.in);
                System.out.println("\n\nplease enter your id from 1-7: ");
                int n=in.nextInt();
                if(n==1)
                {
                    int l=v1.vote();
                    if(l==6)
                        c1.total_votes++;
                    else if(l==7)
                    {
                        c2.total_votes++;
                    }
                }
                if(n==2)
                {
                    int l=v2.vote();
                    if(l==6)
                        c1.total_votes++;
                    else if(l==7)
                    {
                        c2.total_votes++;
                    }
                }
                if(n==3)
                {
                    int l=v3.vote();
                    if(l==6)
                        c1.total_votes++;
                    else if(l==7)
                    {
                        c2.total_votes++;
                    }
                }
                if(n==4)
                {
                    int l=v4.vote();
                    if(l==6)
                        c1.total_votes++;
                    else if(l==7)
                    {
                        c2.total_votes++;
                    }
                }
                if(n==5)
                {
                    int l=v5.vote();
                    if(l==6)
                        c1.total_votes++;
                    else if(l==7)
                    {
                        c2.total_votes++;
                    }
                }
                if(n==6)
                {
                    int l=c1.vote();
                    if(l==6)
                        c1.total_votes++;
                    else if(l==7)
                    {
                        c2.total_votes++;
                    }
                }
                if(n==7)
                {
                    int l=c2.vote();
                    if(l==6)
                        c1.total_votes++;
                    else if(l==7)
                    {
                        c2.total_votes++;
                    }
                }
                System.out.println("total votes of Imran Khan: " +cd.get(0).total_votes );
                System.out.println("total votes of Nawaz Sharif: " +cd.get(1).total_votes );
                System.out.println("total number of voters who casted votes out of 7: " +(cd.get(0).total_votes+cd.get(1).total_votes) );
            }
            
        }
        
        if(formatDateTime.contains("6")==true || t==true)
        {
            k1.print();
            k2.print();
        }
    }
    
}
