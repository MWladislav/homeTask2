import domain.Text;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.TextService;
import util.FileWorker;
import util.TextParser;

import java.util.ArrayList;

public class TextParserTest {

    @Test
    public void readTextTest(){
        FileWorker fileWorker= new FileWorker();
        String text = fileWorker.readText("D:\\Java\\Workspace\\homeTask2\\src\\main\\resources\\Text.txt");
        System.out.println(text);
        Assert.assertNotNull(text);
    }

    @Test
    public void parseTest(){
        FileWorker fileWorker= new FileWorker();
        TextParser textParser=new TextParser();
        String text=fileWorker.readText("D:\\Java\\Workspace\\homeTask2\\src\\main\\resources\\Text.txt");
        Text textObj=textParser.parseToText(text);
        String result=textParser.parseText(textObj);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public  void sortTest(){
        FileWorker fileWorker= new FileWorker();
        TextParser textParser=new TextParser();
        TextService service= new TextService();
        String text=fileWorker.readText("D:\\Java\\Workspace\\homeTask2\\src\\main\\resources\\Text.txt");
        Text textObj=textParser.parseToText(text);
        ArrayList<String> result= service.printWordsSortedByFirstLetter(textObj);
        result.forEach(System.out::println);

    }

}
