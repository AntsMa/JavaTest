package com.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
//public static void getAllFileName(String path,ArrayList<String> fileName)是包括当前文件及其子文件的文件名。

public class GetFileName
{
    public static String [] getFileName(String path)
    {
        File file = new File(path);
        String [] fileName = file.list();
        return fileName;
    }
    public static void getAllFileName(String path,ArrayList<String> fileName)
    {
        File file = new File(path);
        File [] files = file.listFiles();
        String [] names = file.list();
        if(names != null)
        fileName.addAll(Arrays.asList(names));
        for(File a:files)
        {
            if(a.isDirectory())
            {
                getAllFileName(a.getAbsolutePath(),fileName);
            }
        }
    }
    
    public static void main(String[] args)
    {
        String [] fileName = getFileName("D:\\workSpaceAsiaInfoRjil\\RJIL_businesscommon\\src\\com\\ai\\rjil\\veriscrm\\paas\\businesscommon\\abo\\vo");
        for(String name:fileName)
        {
            System.out.println(name);
        }
        System.out.println("--------------------------------");
        ArrayList<String> listFileName = new ArrayList<String>(); 
        String filePath1 = "D:\\workSpaceAsiaInfoRjil\\RJIL_customer\\src\\com\\ai\\rjil\\veriscrm\\paas\\customer\\abo\\vo";
        String filePath2 = "D:\\workSpaceAsiaInfoRjil\\RJIL_businesscommon\\src\\com\\ai\\rjil\\veriscrm\\paas\\businesscommon\\abo\\vo";
        String filePath3 = "D:\\workSpaceAsiaInfoRjil\\RJIL_order\\src\\com\\ai\\rjil\\veriscrm\\paas\\order\\abo\\vo";
        getAllFileName(filePath1,listFileName);
       
        for(String name:listFileName)
        {
        	if(-1 != name.indexOf("4MDM"))
        	{
        		System.out.println(name);
        	}
        }
        
    }
}