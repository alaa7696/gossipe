package com.sqli;

import java.util.ArrayList;
import java.util.List;

public class Gossips {
    int index=0;
    String currentSay;
    String name1;
    String name2;
    String name3;
    List<Mister> misters;
    List<String> senders;

    public Gossips(String name1, String name2, String name3) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        misters =new ArrayList<Mister>();
        senders=new ArrayList<String>();
    }

    public Gossips from(String name) {
        return new GossipsBuilder(this, name).from();
        /*Mister mister=new Mister(name);
        senders.add(name);
        if(findMister(misters,name)==null)
        misters.add(mister);
        return this;*/
    }

    public Gossips to(String name) {
        if(currentSay!=null){
            Mister mister=findMister(misters,name);
            mister.say=currentSay;
        }
        else {
            return new GossipsBuilder(this, name).to();
           /* Mister receptor = new Mister(name);
            misters.get(misters.size() - 1).receptor = name;
            if(findMister(misters,name)==null)
            misters.add(receptor);*/
        }
        return this;
    }


    public Gossips say(String say) {
        this.currentSay=say;
        return this;
    }



    public String ask(String name) {

        if(findMister(misters,name)!=null){
        return findMister(misters,name).say;
        }
        return "rien";
    }


    public Mister findMister(List<Mister> mistersFrom, String name) {
        for(Mister m:mistersFrom)
            if (m.name.equals(name))
                return m;
        return null;
    }

    public void spread() {
        String senderName=senders.get(index);
        Mister mister=findMister(misters,senderName);
        Mister rec=findMister(misters,mister.receptor);
        rec.say= mister.say;
        mister.say="";
        index++;
    }
}
