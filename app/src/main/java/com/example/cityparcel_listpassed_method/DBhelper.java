package com.example.cityparcel_listpassed_method;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.cityparcel_listpassed_method.Fragment.gift;
import com.example.cityparcel_listpassed_method.model.Homemadehotels;
import com.example.cityparcel_listpassed_method.model.Photosclass;
import com.example.cityparcel_listpassed_method.model.restorant;

import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {
    public static String DB_NAME = "RestroDB";
    public static int DB_VERSION = 34;

    public DBhelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Hotellist (id INTEGER PRIMARY KEY AUTOINCREMENT,hotelid TEXT,Name TEXT,description TEXT,faverites TEXT,Reviw TEXT,image TEXT,Prize TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Homemadelist (id INTEGER PRIMARY KEY AUTOINCREMENT,hotelid TEXT,Name TEXT,description TEXT,faverites TEXT,Reviw TEXT,image TEXT,Prize TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Farmfoodlist (id INTEGER PRIMARY KEY AUTOINCREMENT,farmid TEXT,Name TEXT,description TEXT,faverites TEXT,Reviw TEXT,image TEXT,Prize TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Giftlist (id INTEGER PRIMARY KEY AUTOINCREMENT,giftid TEXT,Name TEXT,description TEXT,faverites TEXT,Reviw TEXT,image TEXT,Prize TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Menu (id INTEGER PRIMARY KEY AUTOINCREMENT ,hotelid TEXT,Hotelname TEXT,Contain TEXT,Prize TEXT,category TEXT,service_type TEXT,image TEXT,count TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Photos (id INTEGER PRIMARY KEY AUTOINCREMENT ,hotelid TEXT,image TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Review  (id INTEGER PRIMARY KEY AUTOINCREMENT ,hotelid TEXT,Name TEXT,Image TEXT,Comment TEXT,date TEXT,ReviewAvrage TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AboutCusin  (id INTEGER PRIMARY KEY AUTOINCREMENT ,hotelid TEXT,type TEXT,cusin TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AboutFacilities  (id INTEGER PRIMARY KEY AUTOINCREMENT ,hotelid TEXT,type TEXT,facilities TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ordercart  (id INTEGER PRIMARY KEY AUTOINCREMENT ,hotelid TEXT,Hotelname TEXT,Contain TEXT,Prize TEXT,category TEXT,service_type TEXT,image TEXT,count TEXT,order_id TEXT,cart_type TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS payment  (id INTEGER PRIMARY KEY AUTOINCREMENT ,hotelid TEXT,Name TEXT,Address TEXT,landmark TEXT,State TEXT,City TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Paymentstart (id INTEGER PRIMARY KEY AUTOINCREMENT,cardno TEXT,Name TEXT,date TEXT,CVV_no TEXT)");

    }




    public void addcardpayinfo(String cardno, String Name, String date, String CVV_no) {
        ContentValues values = new ContentValues();
        values.put("cardno", cardno);
        values.put("Name", Name);
        values.put("date", date);
        values.put("CVV_no", CVV_no);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Paymentstart", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<carddetail> getcardinfo() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM Paymentstart";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<carddetail> cardpay = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String cardno = cursor.getString(cursor.getColumnIndex("cardno"));
                String Name = cursor.getString(cursor.getColumnIndex("Name"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                String CVV_no = cursor.getString(cursor.getColumnIndex("CVV_no"));

                cardpay.add(new carddetail(cardno, Name, date, CVV_no));
            } while (cursor.moveToNext());
        }

        return cardpay;
    }

    public void addpaymentinfo(String hotelid, String Name, String Address, String landmark, String State, String City) {
        ContentValues values = new ContentValues();
        values.put("hotelid", hotelid);
        values.put("Name", Name);
        values.put("Address", Address);
        values.put("landmark", landmark);
        values.put("State", State);
        values.put("City", City);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("payment", null, values);
        db.close();
    }

    @SuppressLint({"Range", "SuspiciousIndentation"})
    public List<paymentlist> getpaymentinfo() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM payment";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<paymentlist> paymets = new ArrayList<>();
        if (cursor.moveToFirst()) {

            do {
                String hotelid = cursor.getString(cursor.getColumnIndex("id"));
                String Name = cursor.getString(cursor.getColumnIndex("Name"));
                String Address = cursor.getString(cursor.getColumnIndex("Address"));
                String landmark = cursor.getString(cursor.getColumnIndex("landmark"));
                String State = cursor.getString(cursor.getColumnIndex("State"));
                String City = cursor.getString(cursor.getColumnIndex("City"));


                paymets.add(new paymentlist(hotelid, Name, Address, landmark, State, City));
            } while (cursor.moveToNext());
        }

        return paymets;
    }

    public void addshoppingcartinfo(String Hotelnameid, String Hotelname, String Contain, String category, String Prize, String service_type, String image, String count) {

        ContentValues values = new ContentValues();
        values.put("hotelid", Hotelnameid);
        values.put("Hotelname", Hotelname);
        values.put("Contain", Contain);
        values.put("category", category);
        values.put("service_type", service_type);
        values.put("Image", image);
        values.put("prize", Prize);
        values.put("count", count);
        values.put("cart_type", "Cart");

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("ordercart", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<menulist> getcartinfo() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM ordercart";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<menulist> cartorder = new ArrayList<>();

        if (cursor.moveToNext()) {
            do {
                String Hotelid = cursor.getString(cursor.getColumnIndex("hotelid"));
                String Hotelname = cursor.getString(cursor.getColumnIndex("Hotelname"));
                String category = cursor.getString(cursor.getColumnIndex("category"));
                String contain = cursor.getString(cursor.getColumnIndex("Contain"));
                String count = cursor.getString(cursor.getColumnIndex("count"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String Prize = cursor.getString(cursor.getColumnIndex("Prize"));
                String Service_type = cursor.getString(cursor.getColumnIndex("service_type"));


                cartorder.add(new menulist(Hotelid, Hotelname, Prize, contain, category, Service_type, image, count));

            } while (cursor.moveToNext());
        }

        return cartorder;
    }

//    private void UpdateCart(String order_id){
//        SQLiteDatabase db = this.getReadableDatabase();
//        db.execSQL("UPDATE ordercart SET status = 'placed'order_id");
//    }


    public void addaboutinfo2(String hotelid, String type, String facilities) {
        ContentValues values = new ContentValues();
        values.put("hotelid", hotelid);
        values.put("facilities", facilities);
        values.put("type", type);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("AboutFacilities", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<aboutlist> getaboutinfo2() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM AboutFacilities";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<aboutlist> aboutitemfacilities = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String Hotelid = cursor.getString(cursor.getColumnIndex("hotelid"));
                String type = cursor.getString(cursor.getColumnIndex("type"));
                String facilities = cursor.getString(cursor.getColumnIndex("facilities"));

                aboutitemfacilities.add(new aboutlist(Hotelid, type, facilities));

            } while (cursor.moveToNext());
        }

        return aboutitemfacilities;
    }

    public void addaboutinfo1(String hotelid, String type, String cusin) {
        ContentValues values = new ContentValues();
        values.put("hotelid", hotelid);
        values.put("cusine", cusin);
        values.put("type", type);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("AboutCusin", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<aboutlist> getaboutinfo1() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM AboutCusin";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<aboutlist> aboutitem = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String Hotelid = cursor.getString(cursor.getColumnIndex("hotelid"));
                String type = cursor.getString(cursor.getColumnIndex("type"));
                String cusine = cursor.getString(cursor.getColumnIndex("cusine"));

                aboutitem.add(new aboutlist(Hotelid, type, cusine));

            } while (cursor.moveToNext());
        }
        return aboutitem;
    }


    public void addreviewinfo(String hotelid, String Name, String Image, String Comment, String date, String ReviewAvrage) {
        ContentValues values = new ContentValues();
        values.put("hotelid", hotelid);
        values.put("Name", Name);
        values.put("Image", Image);
        values.put("Comment", Comment);
        values.put("date", date);
        values.put("ReviewAvrage", ReviewAvrage);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Review", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<reviewlist> getreviewinfo() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM Review";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<reviewlist> reviewitem = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String Hotelid = cursor.getString(cursor.getColumnIndex("hotelid"));
                String Name = cursor.getString(cursor.getColumnIndex("Name"));
                String Image = cursor.getString(cursor.getColumnIndex("Image"));
                String Comment = cursor.getString(cursor.getColumnIndex("Comment"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                String ReviewAvrage = cursor.getString(cursor.getColumnIndex("ReviewAvrage"));


                reviewitem.add(new reviewlist(Hotelid, Name, Image, Comment, date, ReviewAvrage));
            }
            while (cursor.moveToNext());
        }

        return reviewitem;
    }

    public void addphotoinfo(String hotelid, String image) {
        ContentValues values = new ContentValues();
        values.put("hotelid", hotelid);
        values.put("image", image);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Photos", null, values);
        db.close();
    }


    @SuppressLint("Range")
    public List<Photosclass> getphoyoitem() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM Photos";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<Photosclass> photoitem = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String hotelid = cursor.getString(cursor.getColumnIndex("hotelid"));
                String Image = cursor.getString(cursor.getColumnIndex("image"));
                photoitem.add(new Photosclass(hotelid, Image));
            }
            while (cursor.moveToNext());
        }
        return photoitem;
    }


    public void addmenuinfo(String Hotelnameid, String Hotelname, String Contain, String category, String Prize, String service_type, String image, String count) {
        ContentValues values = new ContentValues();
        values.put("hotelid", Hotelnameid);
        values.put("Hotelname", Hotelname);
        values.put("Contain", Contain);
        values.put("category", category);
        values.put("service_type", service_type);
        values.put("Image", image);
        values.put("prize", Prize);
        values.put("count", count);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Menu", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<menulist> getmenuinfo() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM Menu";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<menulist> hotels = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                String Hotelid = cursor.getString(cursor.getColumnIndex("hotelid"));
                String Hotelname = cursor.getString(cursor.getColumnIndex("Hotelname"));
                String category = cursor.getString(cursor.getColumnIndex("category"));
                String contain = cursor.getString(cursor.getColumnIndex("Contain"));
                String count = cursor.getString(cursor.getColumnIndex("count"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String Prize = cursor.getString(cursor.getColumnIndex("Prize"));
                String Service_type = cursor.getString(cursor.getColumnIndex("service_type"));


                hotels.add(new menulist(Hotelid, Hotelname, Prize, contain, category, Service_type, image, count));


            } while (cursor.moveToNext());
        }


        return hotels;
    }


    public void addgift(String giftid, String Name, String description, String faverites, String Reviw, String image, String Prize) {
        ContentValues values = new ContentValues();
        values.put("Name", Name);
        values.put("description", description);
        values.put("faverites", faverites);
        values.put("Reviw", Reviw);
        values.put("image", image);
        values.put("Prize", Prize);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Giftlist", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<gift> getgift() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM Giftlist";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<gift> giftproduct = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String Name = cursor.getString(cursor.getColumnIndex("Name"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                String faverites = cursor.getString(cursor.getColumnIndex("faverites"));
                String Reviw = cursor.getString(cursor.getColumnIndex("Reviw"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String Prize = cursor.getString(cursor.getColumnIndex("Prize"));

                giftproduct.add(new gift(image, Name, description, faverites, Prize));
            }
            while (cursor.moveToNext());
        }


        return giftproduct;
    }


    public void addfarmfood(String farmid, String Name, String description, String faverites, String Reviw, String image, String Prize) {
        ContentValues values = new ContentValues();
        values.put("Name", Name);
        values.put("description", description);
        values.put("faverites", faverites);
        values.put("Reviw", Reviw);
        values.put("image", image);
        values.put("Prize", Prize);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Farmfoodlist", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<gift> getfarmfood() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM Farmfoodlist";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<gift> farmfood = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String Name = cursor.getString(cursor.getColumnIndex("Name"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                String faverites = cursor.getString(cursor.getColumnIndex("faverites"));
                String Reviw = cursor.getString(cursor.getColumnIndex("Reviw"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String Prize = cursor.getString(cursor.getColumnIndex("Prize"));

                farmfood.add(new gift(image, Name, description, faverites, Prize));
            }
            while (cursor.moveToNext());
        }


        return farmfood;
    }


    public void addhomemade(String hotelid, String Name, String description, String faverites, String Reviw, String image, String Prize) {
        ContentValues values = new ContentValues();
        values.put("Name", Name);
        values.put("description", description);
        values.put("faverites", faverites);
        values.put("Reviw", Reviw);
        values.put("image", image);
        values.put("Prize", Prize);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Homemadelist", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<Homemadehotels> gethomemade() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM Homemadelist";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<Homemadehotels> Homemadeservice = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String Name = cursor.getString(cursor.getColumnIndex("Name"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                String faverites = cursor.getString(cursor.getColumnIndex("faverites"));
                String Reviw = cursor.getString(cursor.getColumnIndex("Reviw"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String Prize = cursor.getString(cursor.getColumnIndex("Prize"));
                Homemadeservice.add(new Homemadehotels(image, Name, description, faverites, Prize));
            } while (cursor.moveToNext());
        }


        return Homemadeservice;
    }


    public void addhotels(String hotelid, String Name, String description, String faverites, String Reviw, String image, String Prize) {
        ContentValues values = new ContentValues();
//            values.put("hotelid", hotelid);
        values.put("Name", Name);
        values.put("description", description);
        values.put("faverites", faverites);
        values.put("Reviw", Reviw);
        values.put("image", image);
        values.put("Prize", Prize);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Hotellist", null, values);
        db.close();

    }

    @SuppressLint("Range")
    public List<restorant> getrestro() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qurey1 = "SELECT * FROM Hotellist";
        Cursor cursor = db.rawQuery(qurey1, new String[]{});
        List<restorant> hotels = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                String hotelid = cursor.getString(cursor.getColumnIndex("id"));
                String Name = cursor.getString(cursor.getColumnIndex("Name"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                String faverites = cursor.getString(cursor.getColumnIndex("faverites"));
                String Reviw = cursor.getString(cursor.getColumnIndex("Reviw"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String Prize = cursor.getString(cursor.getColumnIndex("Prize"));
                hotels.add(new restorant(hotelid, image, Name, description, faverites, Prize));

            } while (cursor.moveToNext());


        }

        return hotels;
    }

    public void Updtaecard(String order_id,String cart_type){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE ordercart SET order_id = '"+order_id+"', cart_type = '"+cart_type+"' WHERE cart_type = 'Cart';");
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ordercart");
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Paymentstart");

//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS payment");
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Shoppingcart");
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS AboutCusin");
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Review");
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Photos");

//      sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Menu");
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Hotellist");
        onCreate(sqLiteDatabase);

    }
}


