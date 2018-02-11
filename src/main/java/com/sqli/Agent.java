package com.sqli;

public class Agent implements Personne{
    public String name;
    public String say;
    public String receptor;
    public String type;
    public boolean receaved;
    public Agent(String name) {
        this.type="Agent";
        this.name = name;
        say="";
    }
    public String ask() {
        return say;
    }

    public String getName() {
        return name;
    }

    public void setSay(String say) {
        StringBuilder stringBuilder=new StringBuilder();
        if(!say.equals("")) {
            if (this.say.equals("")) {
                stringBuilder.append(say);
            } else
                stringBuilder.append(this.say + ", " + say);

            this.say = new String(stringBuilder);
        }
        else this.say="";
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor=receptor;
    }

    public String getSay(String all) {
        return "";
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
