/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco.manager;

import static com.gioco.manager.Manager_gioco.*;
import java.util.Scanner;

/**
 *
 * @author domen
 */
public class test {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        String s = new String();

        inizio();
        do {
            System.out.print(getRisposta());
            resetRisposta();
            s = sc.nextLine();
            testo(s);
        } while (s.contains("esci"));
        
        System.out.println("Grazie per il vostro tempo.");
        
    }
}
