package com.gioco.data;

public class MyFile {
    
    private String name;
    private byte[] data;

    public MyFile(){}
    
    public MyFile(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    
    public void setName(byte[] fileBytes) {
        this.name = new String(fileBytes);
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public byte[] getData() {
        return data;
    }
}
