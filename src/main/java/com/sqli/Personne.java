package com.sqli;

public interface  Personne {
    public String ask();
    public String getName();
    public void setSay(String say);
    public String getReceptor();
    public void setReceptor(String name);
    public String getSay();
    public void setType(String type);
    public String getType();
    public boolean hasReceaved();
    public void setReceived(boolean received);
}
