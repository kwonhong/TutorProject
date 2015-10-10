package com.springapp.mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



/**
 * Created by SEONG on 2015-10-10.
 */
public class InputFileDeclared {

    private FileInputStream in;

    public InputFileDeclared(String filename) throws FileNotFoundException{
        in = new FileInputStream(filename);
    }

    public String getWord() throw IOException{
        int c;
        StringBuffer buf = new StringBuffer();

        do {
            c = in.read();
            if (Character.isSpace(char)c)
            return buf.toString();
            else
            buf.append((char) c);
        }while buf.toString();
    }
}
