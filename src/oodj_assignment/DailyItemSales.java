
package oodj_assignment;

import java.io.IOException;
import java.util.ArrayList;

public class DailyItemSales implements Record {
    private static FileAccess dailyFile = new FileAccess("daily.txt");
    private String date;
    private int amountSold;
    private Item item;
    
    public DailyItemSales(String date, int amountSold, Item item){
        this.date = date;
        this.amountSold = amountSold;
        this.item = item;
    }   
    
    public void add() throws IOException{
        dailyFile.addToFile(toString());
    }
    public void edit(Object newData) throws IOException{
        dailyFile.editFile(toString(),newData.toString());
    }
    public void remove() throws IOException{
        dailyFile.removeFromFile(toString());
    }
    public static ArrayList<String[]> view()throws IOException{
        return dailyFile.viewFile();
    }
    public static ArrayList<String[]> view(ArrayList<String[]> AL,String filter) throws IOException{
        return dailyFile.viewFile(AL,filter);
    }
    public static ArrayList<String[]> view(ArrayList<String[]> AL, int attIndex, String filter){
        return dailyFile.viewFile(AL,attIndex,filter);
    }
    public double totalprice(){
        return amountSold*item.getSellprice();
    }
    public boolean verifyUniqueness()throws IOException{
        String[] data = {date,item.getItemID()};
        int[] i = {0,1};
        return dailyFile.verifyDataUniqueness(data,i);
    }
    public String toString(){
        return (date + "|" + item.toStringForDIS()+  "|" + amountSold + "|" + totalprice());
    }
    public Item getItem(){
        return item;
    }
    public String getDate(){
        return date;
    }
    public int getAmountSold(){
        return amountSold;
    }
}
                                                                    