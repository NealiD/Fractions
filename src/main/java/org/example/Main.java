package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        System.out.println(new Fraction(1400,150));
        System.out.println(new Fraction(52440,3620));
        System.out.println(new Fraction(1260,1260));
        File inputDir=new File("C:/Data/input/input");
        File[] inputFiles= inputDir.listFiles();
        int i =0;
        for(File inputFile : inputFiles)
        {
            //System.out.println("Reading "+inputFile);
            //System.out.println("Ukázka: "+records[0].getName()+" ,"+records[0].getScore());

            ExamRecord[] records = readInputFile(inputFile.toPath());
            File existingFile = new File(inputFile.getName()); //zjistí jaké jméno soubor v inputu má a dá ho do outputového
            String fileName = existingFile.getName(); //jméno souboru
            try (BufferedWriter writer = new BufferedWriter(new FileWriter( "C:/Data/output/"+ fileName))) { // tohle vytvoří záznam v souboru a dá ho do output složky
                for (int j = 0; j < records.length; j++) { //přidá jednotlivé záznami do csv souboru
                writer.write(records[j].getName() + "," + records[j].getScore());
                writer.newLine();
                }
                System.out.println("CSV soubor byl vytvořen."); //potvrzení o udělání souboru
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("Problém při vytváření souboru");
            }
        }

    }

    public static ExamRecord[] readInputFile(Path path)
    {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            return new ExamRecord[0];
        }
        List<ExamRecord> resultList = new ArrayList<>();
        for(String line : lines)
        {
            String[] split= line.split("[:=;]");
            resultList.add(new ExamRecord(
                    split[0],
                    Fraction.parse(split[1])
            ));
        }
        return resultList.toArray(new ExamRecord[0]);
    }
}