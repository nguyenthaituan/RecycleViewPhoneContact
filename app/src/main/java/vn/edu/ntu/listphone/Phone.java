package vn.edu.ntu.listphone;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class Phone extends Application implements IPhone {

    List<Infor> listInfor = new ArrayList<>();

    public Phone(List<Infor> listInfor) {
        this.listInfor = listInfor;
    }

    public Phone()
    {
        listInfor.add(new Infor("01","Nguyễn Thái Tuấn","09/10/1999","0586134488","Phú Yên"));
        listInfor.add(new Infor("02","Nguyễn Thái Thịnh","09/10/1999","0586134488","Khánh Hòa"));
        listInfor.add(new Infor("03","Nguyễn Hạ Quyên","09/10/1999","0586134488","Đà Nẵng"));
        listInfor.add(new Infor("04","Nguyễn Trúc Đào","09/10/1999","0586134488","Hội An"));
        listInfor.add(new Infor("05","Hồ Thị Ly","09/10/1999","0586134488","Hà Nội"));
        listInfor.add(new Infor("06","Huỳnh Thị Kiều Vân","09/10/1999","0586134488","Sài Gòn"));
        listInfor.add(new Infor("07","Đặng Thanh Nhàn","09/10/1999","0586134488","Bình Thuận"));
    }

    @Override
    public List<Infor> getAProducts() {
        return listInfor;
    }
}
