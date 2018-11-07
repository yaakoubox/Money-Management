package Entity;

import howmuchwehave.Tolls;
import javax.swing.JTable;

public class MainUser implements MainData {

    private int Number;
    private double Price;
    private String Name;
    private String Location;
    private String Date;
    private int Number2;
    private double Price2;
    private String Name2;
    private String Location2;
    private String Date2;

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

   public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getNumber2() {
        return Number2;
    }

    public void setNumber2(int Number2) {
        this.Number2 = Number2;
    }

    public double getPrice2() {
        return Price2;
    }

    public void setPrice2(double Price2) {
        this.Price2 = Price2;
    }

    public String getName2() {
        return Name2;
    }

    public void setName2(String Name2) {
        this.Name2 = Name2;
    }

    public String getLocation2() {
        return Location2;
    }

    public void setLocation2(String Location2) {
        this.Location2 = Location2;
    }

    public String getDate2() {
        return Date2;
    }

    public void setDate2(String Date2) {
        this.Date2 = Date2;
    }

    @Override
    public void add() {
        String StrInsert = "insert into mainuser values("
                + Number + ","
                + Price + ",'"
                + Name + "','"
                + Location + "','"
                + Date + "')";
        boolean IsAdd = db.go.runNonQuery(StrInsert);
        if (IsAdd) {
            Tolls.MsgBox("The Element ''"+ Name +"'' is Added :) ");
        }
    }

    @Override
    public void update() {
        String StrUpdate = "update mainuser set "
                + "Price=" + Price + ","
                + "Name='" + Name + "',"
                + "Location='" + Location + "',"
                + "Date='" + Date + "'"
                + "where Number=" + Number;
        boolean IsUpdate = db.go.runNonQuery(StrUpdate);
        if (IsUpdate) {
            Tolls.MsgBox("The Element ''"+ Name +"'' is Updated :) ");
        }
    }

    @Override
    public void delete() {
        String StrDelete = "delete from mainuser where Number=" + Number;
        boolean IsDelete = db.go.runNonQuery(StrDelete);
        if (IsDelete) {
            Tolls.MsgBox("the Element ''"+ Name +"'' is deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return db.go.getAoutoNumber("mainuser", "Number");
        
    }

    @Override
    public void getAllRows(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOneRows(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
       db.go.fillToJTable(statment, table);
    }

    @Override
    public String getValueByName(String name) {
        String sterSelect = "select Number from mainuser where Name2 = '" + name + "'";
        String strVal = db.go.getTableData(sterSelect).Names[0][0].toString();
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "select Name from mainuser where Number = " + value ;
        String strName = db.go.getTableData(strSelect).Names[0][0].toString();
        return strName;
    }

    @Override
    public void add2() {
        String StrInsert = "insert into mainuser2 values("
                + Number2 + ","
                + Price2 + ",'"
                + Name2 + "','"
                + Location2 + "','"
                + Date2 + "')";
        boolean IsAdd2 = db.go.runNonQuery(StrInsert);
        if (IsAdd2) {
            Tolls.MsgBox("The Element ''"+ Name2 +"'' is Added :) ");
        }
    }

    @Override
    public void update2() {
        String StrUpdate2 = "update mainuser2 set "
                + "Price2=" + Price2 + ","
                + "Name2='" + Name2 + "',"
                + "Location2='" + Location2 + "',"
                + "Date2='" + Date2 + "'"
                + "where Number2=" + Number2;
        boolean IsUpdate2 = db.go.runNonQuery(StrUpdate2);
        if (IsUpdate2) {
            Tolls.MsgBox("The Element ''"+ Name2 +"'' is Updated :) ");
        }
    }

    @Override
    public void delete2() {

        String StrDelete2 = "delete from mainuser2 where Number2=" + Number2;
        boolean IsDelete2 = db.go.runNonQuery(StrDelete2);
        if (IsDelete2) {
            Tolls.MsgBox("The Element ''"+ Name2 +"'' is deleted");
        }
    }

    @Override
    public String getAutoNumber2() {
        return db.go.getAoutoNumber("mainuser2", "Number2");
    }

    @Override
    public void getAllRows2(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOneRows2(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCustomRows2(String statment, JTable table) {
        db.go.fillToJTable(statment, table);
    }

    @Override
    public String getValueByName2(String name) {
        String sterSelect = "select Number2 from mainuser2 where Name2 = '" + name + "'";
        String strVal = db.go.getTableData(sterSelect).Names[0][0].toString();
        return strVal;
    }

    @Override
    public String getNameByValue2(String value) {
        String strSelect = "select Name2 from mainuser2 where Number2 = " + value ;
        String strName = db.go.getTableData(strSelect).Names[0][0].toString();
        return strName;
    }

}
