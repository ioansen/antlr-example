package uti.ro.examples;

import org.junit.BeforeClass;
import org.junit.Test;
import uti.ro.examples.csv.CSVLoader;

import java.io.File;

public class CSVTest {

    private static CSVLoader loader;

    @BeforeClass
    public static void initializeFile() throws Exception{
        File file = new File(CSVTest.class.getClassLoader().getResource("input/csv/data.csv").getPath());
        loader = new CSVLoader(file);

    }

    @Test
    public void testCSV(){
        System.out.println(loader.getMaps());
    }
}
