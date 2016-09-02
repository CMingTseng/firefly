package redix.firefly.object;

/**
 * Created by thuyetpham94 on 02/09/2016.
 */
public class ListClass {
    int photo;
    String title;
    String address;
    String price;

    public ListClass(int photo,String title,String address,String price){
        this.photo = photo;
        this.title = title;
        this.address = address;
        this.price = price;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
