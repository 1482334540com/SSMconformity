package com.books.utils;

public class SqlReturnFlag {

    public  static  final boolean updateLine(int line){

        Boolean flag=false;
        if(line>0)
             return true;

        else{
            return false;
        }

    }
}
