package com.sqli;

import java.util.ArrayList;
import java.util.List;

public class Gossips {
    int index=0;
    String currentSay;

    List<Personne> persons;
    List<String> senders;
    String[] names;

    public Gossips(String... names) {

        persons =new ArrayList();
        senders=new ArrayList<String>();
        this.names=names;
    }

    public Gossips from(String name) {
        for(int i=0;i<names.length;i++) {
            String temp=names[i].split(" ")[1];
            if (temp.equals(name))
                name=names[i];
        }
        return new GossipsBuilder(this, name).from();
    }

    public Gossips to(String name) {
        if(currentSay!=null){
            Personne personne= findPersonne(persons,name);
            personne.setSay(currentSay);
        }
        else {
            for(int i=0;i<names.length;i++) {
                String temp=names[i].split(" ")[1];
                if (temp.equals(name))
                    name=names[i];
            }
            return new GossipsBuilder(this, name).to();
        }
        return this;
    }


    public Gossips say(String say) {
        this.currentSay=say;
        return this;
    }



    public String ask(String name) {
        Personne personne= findPersonne(persons,name);
        return personne.ask();
    }


    public Personne findPersonne(List<Personne> mistersFrom, String name) {
        for(Personne m:mistersFrom)
            if (m.getName().equals(name))
                return m;
        return null;
    }

    public void spread1() {
        String senderName=senders.get(index);
        Personne personne= findPersonne(persons,senderName);
        Personne rec= findPersonne(persons,personne.getReceptor());

        rec.setSay(personne.getSay());
        if(personne.getType().equals("Mr"))
            personne.setSay("");

        index++;
    }
    public void spread(){
        for(Personne personne:persons){
            System.out.println(personne.getName()+" => "+personne.getReceptor());
            personne.setReceived(false);
        }
        for(int i=0;i<senders.size();i++){
            String senderName=senders.get(i);
            Personne personne= findPersonne(persons,senderName);
            Personne rec= findPersonne(persons,personne.getReceptor());
            if(!personne.getSay().equals("") && rec.hasReceaved()==false && personne.hasReceaved()==false){
                rec.setSay(personne.getSay());
                personne.setSay("");
                rec.setReceived(true);
                personne.setReceived(true);
            }
        }

    }
}
