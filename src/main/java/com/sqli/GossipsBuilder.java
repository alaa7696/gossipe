package com.sqli;

public class GossipsBuilder {
    Gossips gossips;
    String name;

    public GossipsBuilder(Gossips gossips, String name) {
        this.gossips = gossips;
        this.name = name;


    }

    public Gossips from() {
        Mister mister=new Mister(name);
        gossips.senders.add(name);
        if(gossips.findMister(gossips.misters,name)==null)
            gossips.misters.add(mister);
        return gossips;
    }
    public Gossips to() {
        Mister receptor = new Mister(name);
        gossips.misters.get(gossips.misters.size() - 1).receptor = name;
        if(gossips.findMister(gossips.misters,name)==null)
            gossips.misters.add(receptor);
               return gossips;
    }
}
