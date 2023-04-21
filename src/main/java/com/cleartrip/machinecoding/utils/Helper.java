package com.cleartrip.machinecoding.utils;

import com.cleartrip.machinecoding.Database.Database;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Helper {
    public static Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return o1.get(0) - o2.get(0);
        }
    };

//    private Helper(){}
//    private static Helper helper = null;
//
//    public static Helper getHelper(){
//        if(helper == null){
//            helper = new Helper();
//        }
//        return helper;
//    }
}
