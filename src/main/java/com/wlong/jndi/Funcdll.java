package com.wlong.jndi;

public class Funcdll
{
    static
    {
        Funcdll f=new Funcdll();
        System.load(f.getClass().getResource("/").getPath()+"hello.dll");
    }
    public static void main(String[] args)
    {

        String c_data = "hello,world";
        System.out.println("ok start dll function");
        Funcdll f =  new Funcdll();
        c_data = f.getdll(c_data);
        System.out.println(c_data);

    }
    public native String getdll(String name);
}