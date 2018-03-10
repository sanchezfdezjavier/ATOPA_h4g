package es.upm.h4g.atopa;

import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Data {


    public Data(){
        //empty
    }


    public List<Integer> randoms(int num){
        List<Integer> resultado=null;
        for (int i = 0; i <num ; i++) {
           int random= 1 + (int)(Math.random() * ((25 - 1) + 1));

           resultado.add(random);
        }

        return resultado;
    }

    public HashMap<String, List<String>> respuestas(int numAnsw){
        HashMap<String, List<String>> result= new HashMap<>();

       return null;
    }

    public HashMap<String, List<String>> testHashMap(){
        HashMap<String, List<String>> result= new HashMap<>();

        List<String> aux1=null;
        aux1.add("9");
        aux1.add("3");
        aux1.add("2");
        aux1.add("5");

        List<String> aux2=null;
        aux1.add("3");
        aux1.add("4");


        List<String> aux3=null;
        aux1.add("2");
        aux1.add("7");
        aux1.add("4");

        List<String> aux4=null;
        aux1.add("4");
        aux1.add("2");
        aux1.add("9");


        List<String> aux5=null;
        aux1.add("3");

        List<String> aux6=null;
        aux1.add("10");
        aux1.add("5");
        aux1.add("8");
        aux1.add("4");

        List<String> aux7=null;
        aux1.add("5");
        aux1.add("6");


        List<String> aux8=null;
        aux1.add("3");
        aux1.add("4");
        aux1.add("8");

        List<String> aux9=null;
        aux1.add("2");
        aux1.add("9");
        aux1.add("7");
        aux1.add("6");

        List<String> aux10=null;
        aux1.add("9");
        aux1.add("7");
        aux1.add("10");
        aux1.add("2");

        result.put("1", aux1);
        result.put("2", aux2);
        result.put("3", aux3);
        result.put("4", aux4);
        result.put("5", aux5);
        result.put("6", aux6);
        result.put("7", aux7);
        result.put("8", aux8);
        result.put("9", aux9);
        result.put("10", aux10);

        return result;
    }
}
