package com.sqli;

public class Doctor implements Personne{
    public String name;
    public String say;
    public String receptor;
    public String type;
    public boolean receaved;
    int index;

    public Doctor(String name) {
        this.name = name;
        say="";
        index=0;
    }

    public String ask() {
        return say;
    }

    public String getName() {
        return name;
    }

    public void setSay(String say) {
        System.out.println("dkhoul");
        if(!say.equals("")){

        this.say+=", "+say;

        }
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor=receptor;
    }

    public String getSay() {
        String[] tab=say.split(",");
        return tab[index++].trim();
    }

    public void setType(String type) {
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public boolean hasReceaved() {
        return receaved;
    }

    public void setReceived(boolean received) {
        this.receaved=received;
    }


}
