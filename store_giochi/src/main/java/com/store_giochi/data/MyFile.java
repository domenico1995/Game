package com.store_giochi.data;

public class MyFile {
    
    private String name;
    private byte[] data;

    public MyFile(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public MyFile() {
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setName(byte[] fileBytes) {
        String s = new String(fileBytes);
        this.name = s;
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
