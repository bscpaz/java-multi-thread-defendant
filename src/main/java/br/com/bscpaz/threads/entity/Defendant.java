package br.com.bscpaz.threads.entity;

/*
    Defendant is an individual (or business) against whom a lawsuit is filed.
*/
public class Defendant {
   
    private String name;
    private String hashName;

    public Defendant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getHashName() {
        return hashName;
    }

    public void setHashName(String hashName) {
        this.hashName = hashName;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.hashName;
    }
}
