public class ThoiGian {
    public int Ngay;
    public int Thang;
    public int Nam;
    ThoiGian(String time){
        int i;
        String buffer;
        i = time.indexOf('/');
        buffer = time.substring(0, i); 
        Ngay = Integer.parseInt(buffer);
        time = time.substring(i+1);
        i = time.indexOf('/');
        buffer = time.substring(0, i); 
        Thang = Integer.parseInt(buffer);
        time = time.substring(i+1);
        Nam = Integer.parseInt(time);
    }
}
