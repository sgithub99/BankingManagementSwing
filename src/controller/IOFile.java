/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class IOFile {
    public static void writeFile(List ob, String s){
        ObjectOutputStream w;
        try {
            w = new ObjectOutputStream(new FileOutputStream(s));
            for(Object o1:ob){
                w.writeObject(o1);
            }
            w.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void readFile(List ob, String s){
        ob.clear();
        ObjectInputStream r;
        try {
            r = new ObjectInputStream(new FileInputStream(s));
            Object obj = null;
            try {
                while((obj = r.readObject())!=null){
                Object o1 = (Object)obj;
                ob.add(o1);
            }
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
