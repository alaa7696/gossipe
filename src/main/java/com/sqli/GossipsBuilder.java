package com.sqli;


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
        else if(type.equals("Agent"))
            personne=new Agent(name);

        personne.setSay("");
        personne.setReceived(false);
        gossips.senders.add(name);
        if(gossips.findPersonne(gossips.persons, name)==null)
            gossips.persons.add(personne);
        Gossips.lastPerson=gossips.findPersonne(gossips.persons,name);
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

        else if(type.equals("Agent"))
            personne=new Agent(name);
        personne.setSay("");
        personne.setReceived(false);
        Gossips.lastPerson.setReceptor(name);
        System.out.println("------------"+  Gossips.lastPerson.getName()+"tooooo"+personne.getName());
        if(gossips.findPersonne(gossips.persons, name)==null)
            gossips.persons.add(personne);
        for(Personne personne1:gossips.persons)
            System.out.print(personne1.getName()+" & ");
        System.out.println();   
        return gossips;
    }
}
