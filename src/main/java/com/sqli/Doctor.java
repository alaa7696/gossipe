package com.sqli;

public class Doctor implements Personne{
    public String name;
    public String say;
    public String receptor;
    public String type;
    public boolean receaved;
    public static int index;

    public Doctor(String name) {
        this.type="Dr";
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
        StringBuilder stringBuilder=new StringBuilder();
        if(!say.equals("")){
            if (this.say.equals("")){
                stringBuilder.append(say);
            }

            else
                stringBuilder.append(this.say+", "+say);

            this.say=new String(stringBuilder);
        }

    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor=receptor;
    }

    public String getSay(String all) {
        if(all.equals("all"))
            return say;
        String[] tab=say.split(",");
        return tab[index].trim();
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
