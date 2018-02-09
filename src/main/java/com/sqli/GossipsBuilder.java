package com.sqli;

import java.util.function.Predicate;

public class GossipsBuilder {
    Gossips gossips;
    String allName;

    public GossipsBuilder(Gossips gossips, String allName) {
        this.gossips = gossips;
        this.allName = allName;


    }

    public Gossips from() {

        Personne personne=null;
        String name=allName.split(" ")[1];
        String type=allName.split(" ")[0];
        if(type.equals("Mr")){
            personne=new Mister(name);

        }
        else if(type.equals("Dr")){
            personne=new Doctor(name);
        }
        personne.setSay("");
        personne.setReceived(false);
        personne.setType(type);
        gossips.senders.add(name);
        if(gossips.findPersonne(gossips.persons, name)==null)
            gossips.persons.add(personne);
        return gossips;
    }
    public Gossips to() {
        Personne personne=null;
        String name=allName.split(" ")[1];
        String type=allName.split(" ")[0];
        if(type.equals("Mr")){
            personne=new Mister(name);
        }
        else if(type.equals("Dr")){
            personne=new Doctor(name);
        }
        personne.setType(type);
        personne.setSay("");
        personne.setReceived(false);
        gossips.persons.get(gossips.persons.size() - 1).setReceptor(name);
        if(gossips.findPersonne(gossips.persons, name)==null)
            gossips.persons.add(personne);
        for(Personne personne1:gossips.persons)
            System.out.print(personne1.getName()+" & ");
        System.out.println();   
        return gossips;
    }
}
